/**
 * 
 */
package normalisation;

/**
 * @author mello
 *
 */
public class demo {
	
	public int getCommentLines() {
        String line="";
        int count=0;
        try {
            BufferedReader br=new BufferedReader(new FileReader("linphonecore.c.orig"));
                while((line=br.readLine())!=null)
                {
                    if(line.startsWith("//")) //check for single line comment 
                        count++;
                    else if(line.startsWith("/**")) //check for multiple line comments
                    {
                		count++;
                		while(!(line = br.readLine()).endsWith("*/"))
                		{
                			count++;
                			
                		}
                		count++;
                    	
                    }
                    else 
                    {
                    	if((line.contains("/**")))
                    	{
                			count++;
                			while(!(line = br.readLine()).contains("*/"))
                    		{
                    			count++;
                    			
                    		}
                    		count++;
                			
                		}
                    }

                }
                br.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
             catch (IOException e) {
                e.printStackTrace();
            }
        return count;
    
        } 
	
	    /**
     * Declarations and initialization of Final Variables used in the program 
     * 
     * @param FILE_DIRECTORY - Directory of the files to be evaluated
     * @param COUNT_C_FILE - C or Cpp files
     * @param COUNT_H_FILE - Header files for C
     * @param COUNT_JAVA_FILE - Java files
     */
    private static final String FILE_DIRECTORY = "D:\\\\Untitled Folder\\Normalisation\\";
    private static final String COUNT_C_FILE = ".c";
    private static final String COUNT_H_FILE = ".h";
    private static final String COUNT_JAVA_FILE = ".java";

    /**
     * Counts the number of lines in a file and returns the value for each files
     * 
     * @return Map - A collection of a key and value representing filename and line value
     * 
     * @throws IOException 
     */

    public static Map numberOfCodeLines() throws IOException {
        Map<String, Integer> map = new HashMap<>();
        File directory = new File(FILE_DIRECTORY);
        File[] files = directory.listFiles();
        
        for (File file : files) {
            if (file.isFile() && (file.getName().contains(COUNT_JAVA_FILE)) || (file.getName().contains(COUNT_C_FILE)) || (file.getName().contains(COUNT_H_FILE))) {
                Scanner scanner = new Scanner(new FileReader(file));
                int lineCount = 0;
                try {
                    for (lineCount = 0; scanner.nextLine() != null; lineCount++);
                } catch (NoSuchElementException e) {
                    map.put(file.getName(), lineCount);
                }
            }
        }
        return map;
    }

     /**
     * Counts the number of statements in a file and returns the value for each files
     * 
     * @return Map - A collection of a key and value representing filename and line value
     * 
     * @throws IOException 
     */
 
    public static Map numberOfStatementLines() throws IOException {
       
        Map<String, Integer> map = new HashMap<>();
        File directory = new File(FILE_DIRECTORY);
        File[] files = directory.listFiles();
        
        for (File file : files) {
            if (file.isFile() && (file.getName().contains(COUNT_JAVA_FILE)) || (file.getName().contains(COUNT_C_FILE)) || (file.getName().contains(COUNT_H_FILE))) {
                Scanner scanner = new Scanner(new FileReader(file));
                int statements = 0;
                String str;
                try {
                    for (; scanner.nextLine() != null;) {
                        str = scanner.nextLine();
                        if (str.contains(";")) {
                            statements++;
                        }
                    }
                } catch (NoSuchElementException e) {
                    map.put(file.getName(), statements);
                }
            }
        }
        
        return map;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hola Mundial!");
	}

}
