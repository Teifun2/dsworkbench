/* 
 * Copyright 2015 Torridity.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.tor.tribes.ui;

import de.tor.tribes.types.Tag;
import de.tor.tribes.ui.panels.TroopTableTab.TRANSFER_TYPE;
import java.util.List;

/**
 *
 * @author Torridity
 */
public interface TabInterface {

    public void deregister();

    public void updateFilter(final List<Tag> groups, final boolean pRelation, final boolean pFilterRows);

    public void transferSelection(TRANSFER_TYPE pType);

    public void updateSet();

    public void deleteSelection();

    public void centerVillageInGame();

    public void openPlaceInGame();

    public void centerVillage();

    public void updateSelectionInfo();

}