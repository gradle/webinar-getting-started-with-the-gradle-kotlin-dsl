package org.gradle.webinar.gitutils;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.PersonIdent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GitUtilsTest {

    private long time;

    @TempDir
    public File tempFolder;

    private Git git;

    @BeforeEach
    void setUp() throws GitAPIException, IOException {
        git = Git.init()
                .setDirectory(tempFolder)
                .call();
        file("foo.txt", "initial contents");
        git.add().addFilepattern("foo.txt").call();
        git.commit()
                .setMessage("Initial commit")
                .setAuthor(person("cedric", "cedric@test.org"))
                .call();
    }

    private PersonIdent person(String name, String email) {
        return new PersonIdent(
                name, email,
                new Date(time++),
                TimeZone.getDefault());
    }

    private File file(String name, String contents) throws IOException {
        File file = new File(tempFolder, name);
        try (FileWriter writer = new FileWriter(file, StandardCharsets.UTF_8)) {
            writer.write(contents);
        }
        return file;
    }

    @Test
    void lists_initial_committer() throws IOException {
        GitUtils utils = new GitUtils(tempFolder);
        Set<String> committers = utils.findCommitters();

        assertEquals(committers, Collections.singleton("cedric@test.org"));
    }

    @Test
    void lists_all_committers() throws IOException, GitAPIException {
        GitUtils utils = new GitUtils(tempFolder);
        file("foo.txt", "other contents");
        git.add().addFilepattern("foo.txt").call();
        git.commit()
                .setMessage("Second commit")
                .setAuthor(person("bob", "bob@test.org"))
                .call();
        Set<String> committers = utils.findCommitters();
        assertEquals(committers, new HashSet<>(Arrays.asList("cedric@test.org", "bob@test.org")));
    }


}