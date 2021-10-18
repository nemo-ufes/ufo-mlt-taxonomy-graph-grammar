/*
 * GROOVE: GRaphs for Object Oriented VErification Copyright 2003--2007
 * University of Twente
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * $Id: DefaultFixable.java 5783 2016-08-03 06:22:10Z rensink $
 */
package groove.util;

/**
 * Default implementation of the {@link Fixable} interface.
 * @author Arend
 * @version $Revision $
 */
public class DefaultFixable implements Fixable {
    @Override
    public boolean setFixed() {
        boolean result = !isFixed();
        this.fixed = true;
        return result;
    }

    @Override
    public boolean isFixed() {
        return this.fixed;
    }

    /** Flag indicating if the object is currently fixed. */
    private boolean fixed;
}
