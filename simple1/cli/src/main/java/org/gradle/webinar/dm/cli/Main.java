/*
 * Copyright 2003-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.webinar.dm.cli;

import org.gradle.webinar.gitutils.GitUtils;
import picocli.CommandLine;

import java.io.IOException;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Options options = CommandLine.populateCommand(new Options(), args);
        try {
            GitUtils utils = new GitUtils(options.getRepositoryPath());
            Set<String> committers = utils.findCommitters();
            System.out.println("Committers:" + committers);
            System.out.println("Total committers: " + committers.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
