package org.cucumberRunner;

import java.io.IOException;
import java.util.ArrayList;

import org.commonlibrary.CommonLib;

import cucumber.runtime.ClassFinder;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import static java.util.Arrays.asList;
public class RunCukes extends CommonLib{

	 @SuppressWarnings("unused")
		public void RunningOfCukes(String[] argv) throws Throwable { 
	        byte exitstatus = run(argv, Thread.currentThread().getContextClassLoader());
	    }
	public static byte run(String[] argv, ClassLoader classLoader) throws IOException {
		RuntimeOptions runtimeOptions = new RuntimeOptions(new ArrayList<String>(asList(argv)));
		ResourceLoader resourceLoader = new MultiLoader(classLoader);
		ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
		Runtime runtime = new Runtime(resourceLoader, classFinder, classLoader, runtimeOptions);
		runtime.run();
		return runtime.exitStatus();
	      
	    }
}
