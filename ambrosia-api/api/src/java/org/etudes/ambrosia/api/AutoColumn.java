/**********************************************************************************
 * $URL: https://source.etudes.org/svn/apps/ambrosia/trunk/ambrosia-api/api/src/java/org/etudes/ambrosia/api/AutoColumn.java $
 * $Id: AutoColumn.java 9894 2015-01-23 19:07:22Z mallikamt $
 ***********************************************************************************
 *
 * Copyright (c) 2008, 2015 Etudes, Inc.
 * 
 * Portions completed before September 1, 2008
 * Copyright (c) 2007, 2008 The Regents of the University of Michigan & Foothill College, ETUDES Project
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
 *
 **********************************************************************************/

package org.etudes.ambrosia.api;

/**
 * AutoColumn provides automatic numbering for columns in an entity list.
 */
public interface AutoColumn extends EntityListColumn
{
	/**
	 * Set the property reference for an index to use for the display value.
	 * 
	 * @param propertyReference
	 *        The property reference for an index to use for the display value.
	 */
	AutoColumn setProperty(PropertyReference propertyReference);
	
	/**
	 * Set the indexing to number
	 * 
	 * @return self.
	 */
	AutoColumn setNumeric();
}
