package io.github.mnote.agent;

import com.sun.tools.attach.VirtualMachine;

import java.io.File;

/**
 * Simple attach-on-demand client tool that loads the given agent into the given Java process.
 */
public class ClassDumperAttach {

    public static void main(String[] args) throws Exception {

        String pid = "3687";

        File file = new File("target/aspectj-1.0.0.jar");
        String agent = file.getAbsolutePath();

        System.out.println(agent);

        // JVM is identified by process id (pid).
        VirtualMachine vm = VirtualMachine.attach(pid);

        // load a specified agent onto the JVM
        vm.loadAgent(agent, "dumpDir=./tmp,classes=io.github.*");
    }

}
