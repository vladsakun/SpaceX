/*
 * Copyright 2018 the original author or authors.
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

@file:Suppress(
    "unused",
    "nothing_to_inline",
    "useless_cast",
    "unchecked_cast",
    "extension_shadowed_by_member",
    "redundant_projection",
    "RemoveRedundantBackticks",
    "ObjectPropertyName",
    "deprecation"
)
@file:org.gradle.api.Generated

/* ktlint-disable */

package gradle.kotlin.dsl.accessors._5a9670b36b1848100d3488a4227987a3


import org.gradle.api.Action
import org.gradle.api.artifacts.*
import org.gradle.api.artifacts.dsl.ArtifactHandler
import org.gradle.api.artifacts.dsl.DependencyConstraintHandler
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.accessors.runtime.addConfiguredDependencyTo
import org.gradle.kotlin.dsl.accessors.runtime.addDependencyTo
import org.gradle.kotlin.dsl.accessors.runtime.addExternalModuleDependencyTo
import org.gradle.kotlin.dsl.add
import org.gradle.kotlin.dsl.create


/**
 * Adds a dependency to the 'testFixturesDebugApi' configuration.
 *
 * @param dependencyNotation notation for the dependency to be added.
 * @return The dependency.
 *
 * @see [DependencyHandler.add]
 */
internal
fun DependencyHandler.`testFixturesDebugApi`(dependencyNotation: Any): Dependency? =
    add("testFixturesDebugApi", dependencyNotation)

/**
 * Adds a dependency to the 'testFixturesDebugApi' configuration.
 *
 * @param dependencyNotation notation for the dependency to be added.
 * @param dependencyConfiguration expression to use to configure the dependency.
 * @return The dependency.
 *
 * @see [DependencyHandler.add]
 */
internal
fun DependencyHandler.`testFixturesDebugApi`(
    dependencyNotation: String,
    dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
    this, "testFixturesDebugApi", dependencyNotation, dependencyConfiguration
) as ExternalModuleDependency

/**
 * Adds a dependency to the 'testFixturesDebugApi' configuration.
 *
 * @param dependencyNotation notation for the dependency to be added.
 * @param dependencyConfiguration expression to use to configure the dependency.
 * @return The dependency.
 *
 * @see [DependencyHandler.add]
 */
internal
fun DependencyHandler.`testFixturesDebugApi`(
    dependencyNotation: Provider<*>,
    dependencyConfiguration: Action<ExternalModuleDependency>
): Unit = addConfiguredDependencyTo(
    this, "testFixturesDebugApi", dependencyNotation, dependencyConfiguration
)

/**
 * Adds a dependency to the 'testFixturesDebugApi' configuration.
 *
 * @param group the group of the module to be added as a dependency.
 * @param name the name of the module to be added as a dependency.
 * @param version the optional version of the module to be added as a dependency.
 * @param configuration the optional configuration of the module to be added as a dependency.
 * @param classifier the optional classifier of the module artifact to be added as a dependency.
 * @param ext the optional extension of the module artifact to be added as a dependency.
 * @param dependencyConfiguration expression to use to configure the dependency.
 * @return The dependency.
 *
 * @see [DependencyHandler.create]
 * @see [DependencyHandler.add]
 */
internal
fun DependencyHandler.`testFixturesDebugApi`(
    group: String,
    name: String,
    version: String? = null,
    configuration: String? = null,
    classifier: String? = null,
    ext: String? = null,
    dependencyConfiguration: Action<ExternalModuleDependency>? = null
): ExternalModuleDependency = addExternalModuleDependencyTo(
    this,
    "testFixturesDebugApi",
    group,
    name,
    version,
    configuration,
    classifier,
    ext,
    dependencyConfiguration
)

/**
 * Adds a dependency to the 'testFixturesDebugApi' configuration.
 *
 * @param dependency dependency to be added.
 * @param dependencyConfiguration expression to use to configure the dependency.
 * @return The dependency.
 *
 * @see [DependencyHandler.add]
 */
internal
fun <T : ModuleDependency> DependencyHandler.`testFixturesDebugApi`(
    dependency: T,
    dependencyConfiguration: T.() -> Unit
): T = add("testFixturesDebugApi", dependency, dependencyConfiguration)

/**
 * Adds a dependency constraint to the 'testFixturesDebugApi' configuration.
 *
 * @param constraintNotation the dependency constraint notation
 *
 * @return the added dependency constraint
 *
 * @see [DependencyConstraintHandler.add]
 */
internal
fun DependencyConstraintHandler.`testFixturesDebugApi`(constraintNotation: Any): DependencyConstraint? =
    add("testFixturesDebugApi", constraintNotation)

/**
 * Adds a dependency constraint to the 'testFixturesDebugApi' configuration.
 *
 * @param constraintNotation the dependency constraint notation
 * @param block the block to use to configure the dependency constraint
 *
 * @return the added dependency constraint
 *
 * @see [DependencyConstraintHandler.add]
 */
internal
fun DependencyConstraintHandler.`testFixturesDebugApi`(
    constraintNotation: Any,
    block: DependencyConstraint.() -> Unit
): DependencyConstraint? =
    add("testFixturesDebugApi", constraintNotation, block)

/**
 * Adds an artifact to the 'testFixturesDebugApi' configuration.
 *
 * @param artifactNotation the group of the module to be added as a dependency.
 * @return The artifact.
 *
 * @see [ArtifactHandler.add]
 */
internal
fun ArtifactHandler.`testFixturesDebugApi`(artifactNotation: Any): PublishArtifact =
    add("testFixturesDebugApi", artifactNotation)

/**
 * Adds an artifact to the 'testFixturesDebugApi' configuration.
 *
 * @param artifactNotation the group of the module to be added as a dependency.
 * @param configureAction The action to execute to configure the artifact.
 * @return The artifact.
 *
 * @see [ArtifactHandler.add]
 */
internal
fun ArtifactHandler.`testFixturesDebugApi`(
    artifactNotation: Any,
    configureAction: ConfigurablePublishArtifact.() -> Unit
): PublishArtifact =
    add("testFixturesDebugApi", artifactNotation, configureAction)



