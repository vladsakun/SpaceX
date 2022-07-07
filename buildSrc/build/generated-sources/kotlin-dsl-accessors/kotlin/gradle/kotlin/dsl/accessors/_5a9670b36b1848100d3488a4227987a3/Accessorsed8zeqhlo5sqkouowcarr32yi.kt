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


/**
 * Retrieves the [ext][org.gradle.api.plugins.ExtraPropertiesExtension] extension.
 */
internal
val com.android.build.api.variant.LibraryAndroidComponentsExtension.`ext`: org.gradle.api.plugins.ExtraPropertiesExtension
    get() =
        (this as org.gradle.api.plugins.ExtensionAware).extensions.getByName("ext") as org.gradle.api.plugins.ExtraPropertiesExtension

/**
 * Configures the [ext][org.gradle.api.plugins.ExtraPropertiesExtension] extension.
 */
internal
fun com.android.build.api.variant.LibraryAndroidComponentsExtension.`ext`(configure: Action<org.gradle.api.plugins.ExtraPropertiesExtension>): Unit =
    (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("ext", configure)



