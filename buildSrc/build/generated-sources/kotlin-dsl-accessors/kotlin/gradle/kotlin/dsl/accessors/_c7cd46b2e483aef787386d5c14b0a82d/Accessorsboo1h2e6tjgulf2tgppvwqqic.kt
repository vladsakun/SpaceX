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

package gradle.kotlin.dsl.accessors._c7cd46b2e483aef787386d5c14b0a82d


import org.gradle.api.Action


/**
 * Retrieves the [androidComponents][com.android.build.api.variant.LibraryAndroidComponentsExtension] extension.
 */
internal
val org.gradle.api.Project.`androidComponents`: com.android.build.api.variant.LibraryAndroidComponentsExtension
    get() =
        (this as org.gradle.api.plugins.ExtensionAware).extensions.getByName("androidComponents") as com.android.build.api.variant.LibraryAndroidComponentsExtension

/**
 * Configures the [androidComponents][com.android.build.api.variant.LibraryAndroidComponentsExtension] extension.
 */
internal
fun org.gradle.api.Project.`androidComponents`(configure: Action<com.android.build.api.variant.LibraryAndroidComponentsExtension>): Unit =
    (this as org.gradle.api.plugins.ExtensionAware).extensions.configure(
        "androidComponents",
        configure
    )



