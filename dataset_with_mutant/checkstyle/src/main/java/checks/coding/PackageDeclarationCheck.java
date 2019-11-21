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
import api.Check;
import api.DetailAST;
import api.TokenTypes;
import specifications.Configuration;


/**
 * Ensures there is a package declaration.
 * Rationale: Classes that live in the null package cannot be
 * imported. Many novice developers are not aware of this.
 *
 * @author <a href="mailto:simon@redhillconsulting.com.au">Simon Harris</a>
 * @author Oliver Burn
 */
public final class PackageDeclarationCheck extends Check
{
//	@Conditional
//	private static boolean PackageDeclaration = true;
	
	@Override
	public boolean isEnabled() {
		return Configuration.PackageDeclaration;
	}
    /**
     * A key is pointing to the warning message text in "messages.properties"
     * file.
     */
    public static final String MSG_KEY = "missing.package.declaration";

    /** is package defined. */
    private boolean defined;

    @Override
    public int[] getDefaultTokens()
    {
        return new int[] {TokenTypes.PACKAGE_DEF};
    }

    @Override
    public int[] getRequiredTokens()
    {
        return getDefaultTokens();
    }

    @Override
    public int[] getAcceptableTokens()
    {
        return new int[] {TokenTypes.PACKAGE_DEF};
    }

    @Override
    public void beginTree(DetailAST ast)
    {
        defined = false;
    }

    @Override
    public void finishTree(DetailAST ast)
    {
        if (!defined) {
            log(ast.getLineNo(), MSG_KEY);
        }
    }

    @Override
    public void visitToken(DetailAST ast)
    {
        defined = true;
    }
}
