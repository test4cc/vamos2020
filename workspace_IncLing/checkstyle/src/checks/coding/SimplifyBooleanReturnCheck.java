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

import antlr.collections.AST;
//import gov.nasa.jpf.annotation.Conditional;
import api.Check;
import api.DetailAST;
import api.TokenTypes;
import specifications.Configuration;

/**
 * <p>
 * Checks for overly complicated boolean return statements.
 * Idea shamelessly stolen from the equivalent PMD rule (pmd.sourceforge.net).
 * </p>
 * <p>
 * An example of how to configure the check is:
 * </p>
 * <pre>
 * &lt;module name="SimplifyBooleanReturn"/&gt;
 * </pre>
 * @author Lars Kühne
 */
public class SimplifyBooleanReturnCheck
    extends Check
{
//	@Conditional
//	private static boolean SimplifyBooleanReturn = true;
	
	@Override
	public boolean isEnabled() {
		return Configuration.SimplifyBooleanReturn;
	}
    /**
     * A key is pointing to the warning message text in "messages.properties"
     * file.
     */
    public static final String MSG_KEY = "simplify.boolreturn";

    @Override
    public int[] getDefaultTokens()
    {
        return new int[] {TokenTypes.LITERAL_IF};
    }

    @Override
    public int[] getAcceptableTokens()
    {
        return new int[] {TokenTypes.LITERAL_IF};
    }

    @Override
    public void visitToken(DetailAST ast)
    {
        // LITERAL_IF has the following four or five children:
        // '('
        // condition
        // ')'
        // thenStatement
        // [ LITERAL_ELSE (with the elseStatement as a child) ]

        // don't bother if this is not if then else
        final AST elseLiteral =
            ast.findFirstToken(TokenTypes.LITERAL_ELSE);
        if (elseLiteral == null) {
            return;
        }
        final AST elseStatement = elseLiteral.getFirstChild();

        // skip '(' and ')'
        // TODO: Introduce helpers in DetailAST
        final AST condition = ast.getFirstChild().getNextSibling();
        final AST thenStatement = condition.getNextSibling().getNextSibling();

        if (returnsOnlyBooleanLiteral(thenStatement)
            && returnsOnlyBooleanLiteral(elseStatement))
        {
            log(ast.getLineNo(), ast.getColumnNo(), MSG_KEY);
        }
    }

    /**
     * Returns if an AST is a return statment with a boolean literal
     * or a compound statement that contains only such a return statement.
     *
     * Returns <code>true</code> iff ast represents
     * <br/>
     * <pre>
     * return true/false;
     * </pre>
     * or
     * <br/>
     * <pre>
     * {
     *   return true/false;
     * }
     * </pre>
     *
     * @param ast the sytax tree to check
     * @return if ast is a return statment with a boolean literal.
     */
    private static boolean returnsOnlyBooleanLiteral(AST ast)
    {
        if (isBooleanLiteralReturnStatement(ast)) {
            return true;
        }

        final AST firstStmnt = ast.getFirstChild();
        return isBooleanLiteralReturnStatement(firstStmnt);
    }

    /**
     * Returns if an AST is a return statment with a boolean literal.
     *
     * Returns <code>true</code> iff ast represents
     * <br/>
     * <pre>
     * return true/false;
     * </pre>
     *
     * @param ast the sytax tree to check
     * @return if ast is a return statment with a boolean literal.
     */
    private static boolean isBooleanLiteralReturnStatement(AST ast)
    {
        if ((ast == null) || (ast.getType() != TokenTypes.LITERAL_RETURN)) {
            return false;
        }

        final AST expr = ast.getFirstChild();

        if ((expr == null) || (expr.getType() == TokenTypes.SEMI)) {
            return false;
        }

        final AST value = expr.getFirstChild();
        return isBooleanLiteralType(value.getType());
    }

    /**
     * Checks if a token type is a literal true or false.
     * @param tokenType the TokenType
     * @return true iff tokenType is LITERAL_TRUE or LITERAL_FALSE
     */
    private static boolean isBooleanLiteralType(final int tokenType)
    {
        final boolean iastrue = (tokenType == TokenTypes.LITERAL_TRUE);
        final boolean isFalse = (tokenType == TokenTypes.LITERAL_FALSE);
        return iastrue || isFalse;
    }
}
