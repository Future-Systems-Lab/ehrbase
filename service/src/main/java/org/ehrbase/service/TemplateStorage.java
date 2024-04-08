/*
 * Copyright (c) 2024 vitasystems GmbH.
 *
 * This file is part of project EHRbase
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ehrbase.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.ehrbase.api.knowledge.TemplateMetaData;
import org.openehr.schemas.v1.OPERATIONALTEMPLATE;

public interface TemplateStorage {

    /**
     * List all Templates in the store;
     *
     * @return @see {@link TemplateMetaData}
     */
    List<TemplateMetaData> listAllOperationalTemplates();

    /**
     * Save a template in the store
     *
     * @param template @see {@link OPERATIONALTEMPLATE}
     * @throws RuntimeException template Id or uuid are not unique
     */
    void storeTemplate(OPERATIONALTEMPLATE template);

    /**
     * Find and return a saved Template by templateId
     * @param templateId
     * @return the template @see {@link OPERATIONALTEMPLATE} or {@link Optional#empty()} if not found.
     */
    Optional<OPERATIONALTEMPLATE> readOperationaltemplate(String templateId);

    /**
     * Deletes an operational template from template storage. The template will be removed physically so ensure that
     * there are no compositions referencing the template.
     *
     * @param templateId - Template id to delete from storage, e.g. "IDCR Allergies List.v0"
     * @return - Deletion was successful or not
     */
    boolean deleteTemplate(String templateId);

    Optional<String> findTemplateIdByUuid(UUID uuid);

    Optional<UUID> findUuidByTemplateId(String templateId);
}
