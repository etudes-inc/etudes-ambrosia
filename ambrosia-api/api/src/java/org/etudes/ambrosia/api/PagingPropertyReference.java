/**********************************************************************************
 * $URL: https://source.etudes.org/svn/apps/ambrosia/trunk/ambrosia-api/api/src/java/org/etudes/ambrosia/api/PagingPropertyReference.java $
 * $Id: PagingPropertyReference.java 3632 2012-12-02 21:19:56Z ggolden $
 ***********************************************************************************
 *
 * Copyright (c) 2008 Etudes, Inc.
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
 * pagingPropertyReference handles Paging references.
 */
public interface PagingPropertyReference extends PropertyReference
{
	static final String FIRST = "FIRST";

	static final String LAST = "LAST";

	static final String NEXT = "NEXT";

	static final String PREV = "PREV";

	static final String SELECTOR = "ambrosia:pagingSelector";

	static final String SELECTOR_SIZE = "ambrosia:pagingSelectorSize";

	static final String SIZE = "size";
}