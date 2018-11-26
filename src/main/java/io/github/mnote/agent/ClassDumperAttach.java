package io.github.mnote.agent;

import com.sun.tools.attach.VirtualMachine;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.lang.management.ManagementFactory;

/**
 * Simple attach-on-demand client tool that loads the given agent into the given Java process.
 */
public class ClassDumperAttach {

    public static void main(String[] args) throws Exception {
        attach();
    }

    public static void attach() throws Exception {

        String pid = pid();

        System.out.println("pid: " + pid);

        File file = new File("target/aspectj-1.0.0.jar");
        String agent = file.getAbsolutePath();

        System.out.println("agent: " + agent);

        // JVM is identified by process id (pid).
        VirtualMachine vm = VirtualMachine.attach(pid);

        File tmp = new File("./tmp");
        if (tmp.isDirectory()) {
            System.out.println("removing: " + tmp.getAbsolutePath());
            FileUtils.deleteDirectory(tmp);
        }

        // load a specified agent onto the JVM
        vm.loadAgent(agent, "dumpDir=./tmp,classes=io.github.*");

    }

    public static String pid() {
        String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println("jvmName: " + jvmName);
        return jvmName.split("@")[0];
    }


}
