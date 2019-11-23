////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code for adherence to a set of rules.
// Copyright (C) 2001-2015 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
////////////////////////////////////////////////////////////////////////////////
package checks.coding;

//import gov.nasa.jpf.annotation.Conditional;
import api.DetailAST;
import api.TokenTypes;
import specifications.Configuration;

/**
 * Restricts nested try-catch-finally blocks to a specified depth (default = 1).
 * @author <a href="mailto:simon@redhillconsulting.com.au">Simon Harris</a>
 */
public final class NestedTryDepthCheck extends AbstractNestedDepthCheck
{
//	@Conditional
//	private static boolean NestedTryDepth = true;
	
	@Override
	public boolean isEnabled() {
		return Configuration.NestedTryDepth;
	}
    /**
     * A key is pointing to the warning message text in "messages.properties"
     * file.
     */
    public static final String MSG_KEY = "nested.try.depth";

    /** default allowed nesting depth */
    private static final int DEFAULT_MAX = 1;

    /** Creates new check instance with default allowed nesting depth. */
    public NestedTryDepthCheck()
    {
        super(DEFAULT_MAX);
    }

    @Override
    public int[] getDefaultTokens()
    {
        return new int[] {TokenTypes.LITERAL_TRY};
    }

    @Override
    public int[] getAcceptableTokens()
    {
        return new int[] {TokenTypes.LITERAL_TRY};
    }

    @Override
    public void visitToken(DetailAST ast)
    {
        switch (ast.getType()) {
            case TokenTypes.LITERAL_TRY:
                visitLiteralTry(ast);
                break;
            default:
                throw new IllegalStateException(ast.toString());
        }
    }

    @Override
    public void leaveToken(DetailAST ast)
    {
        switch (ast.getType()) {
            case TokenTypes.LITERAL_TRY:
                leaveLiteralTry();
                break;
            default:
                throw new IllegalStateException(ast.toString());
        }
    }

    /**
     * Increases current nesting depth.
     * @param literalTry node for try.
     */
    private void visitLiteralTry(DetailAST literalTry)
    {
        nestIn(literalTry, MSG_KEY);
    }

    /** Decreases current nesting depth */
    private void leaveLiteralTry()
    {
        nestOut();
    }
}
