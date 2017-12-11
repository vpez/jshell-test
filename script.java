/env -class-path /Users/vahepezeshkian/Desktop/java-script/commons-io-2.6.jar
import org.apache.commons.io.*;

BiConsumer<String, OutputStream> writer = (String s, OutputStream out) -> {
	try {
		IOUtils.write(s, out);
	} catch(IOException e) {
		// Ignore
	}
};

OutputStream out = new FileOutputStream("output.txt");
Arrays.asList("Apple", "Orange", "Banana").stream().forEach(s -> writer.accept(s + "\n", out));

/exit
