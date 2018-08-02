/**find all the employees having first_name and last_name alongwith their salary information.
    *select id, first_name,last_name,salary,bonus 
    *from employee_name LEFT OUTER JOIN employee_pay 
    *ON employee_name.id = employee_pay.id;
    
    *two mappers would be required
    *One for employee_name csv object
    *Second for employee_pay Object
    */

public class LeftOuterJoin{
    private static final Logger logger = LoggerFactory.getLogger(LeftOuterJoin.class);

    public static void main(String[] args){
        String nameFilePath = args[0];
        String payFilePath = args[1];

        Path empNamePath = new Path("hdfs://localhost:9000/"+ nameFilePath);
        Path empPayPath = new Path("hdfs://localhost:9000/"+ payFilePath);
        path empLeftOuterJoinPath = new Path("hdfs://localhost:9000/user/xyz/hdp/output/employee_join.csv");

        Configuration conf = new Configuration();
        Job leftOuterJoinJob = new Job(conf, "LeftOuterJoin");
        leftOuterJoinJob.setjarByClass(LeftOuterJoin.class);
        leftOuterJoinJob.setReducerClass(LeftOuterJoinReducer.class);
        /**
         * Creating two mappers, one for employee_name and another for employee_pay
         * LeftOuterJoinNameMapper reads the data and emits key-value pair composed of
         * id and employee_name object as text LeftOuterJoinPayMapper reads the data and
         * emits key-value pair composed of id and employee_pay Object as text
         */
        leftOuterJoinJob.setMapOutPutKeyClass(CustomObject.class);
        leftOuterJoinJob.setMapOutPutValueClass(CustomObject.class);
        leftOuterJoinJob.setOutputKeyClass(Text.class);
        leftOuterJoinJob.setOutputValueClass(Text.class);
        /**
         * output format can be updated to a 
         * custom writable data type instead of textformat
         */
        leftOuterJoinJob.setInputFormatClass(TextInputFormat.class);
        leftOuterJoinJob.setOutputFormatClass(TextOutputFormat.class);
        
        MultipleInputs.addInputPath(leftOuterJoinJob, empNamePath, TextInputFormat.class, LeftOuterJoinNameMapper.class);
        MultipleInputs.addInputPath(leftOuterJoinJob, empPayPath, TextInputFormat.class, LeftOuterJoinPayMapper.class);        
        FileOutputFormat.setOutputPath(leftOuterJoinJob, empLeftOuterJoinPath);

        if(leftOuterJoinJob.waitForCompletion(false)){
             logger.info("leftOuterJoinJob Completed Successfully");
        }
    }
    
    /**
     * PROVIDING ONLY THE PSUEDOCODE AS PER REQUIREMENTS    
     */

    /**
     * Mapper class can be nested class Mapper class for employee name data Reducer
     * cannot identify between the data from the employee name and employee pay To
     * ensure the employee Name is handled first before employee Pay, we need to do
     * a secondary sorting on CustomObject we created
     *  
     */
    public class CustomObject implements WritableComparable{
        String key;
        String value;
        //Generate getters and setters alongwith compareTo and equals methods for the object
    }
    public  class SecondarySortGroupingComparator extends WritableComparator{
        /**
         * Compare between the value and based on this employee name will come first and then employee pay
         * in the reduced list
         */
        public int compare(){
            return a.value().compareTo(b.getValue());
        }
    }
    public static class LeftJoinEmployeeNameMapper extends Mapper<LongWritable,Text, CustomObject, CustomObject> {
        /**
         * Create a custom object for handling between employee name 
         * and employee pay as a separate nested pojo class
         */
        CustomObject outputkey = new CustomObject();
        CustomObject outputValue = new CustomObject();
        
        public void map(key, value){
            String[] arrTemp = value.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            /**
             * convert either to a text format using employee_name object or
             * create a custom writable data type for output
             */
            String id = arrTemp[0];
            employee_name empName = new employee_name();
            empName.setFirst_name(arrName[1]);
            empName.setLast_name(arrName[2]);
            
            outputKey = Pair(id, 1); 
            outputValue = Pair("n", empName);
            context.write(outputKey, outputValue);
        }
    }
    /** 
     * Mapper class can be a nested class
     * Mapper class for employee pay data 
     * Reducer cannot identify between the data from the employee name and employee pay
     */
    public static class LeftJoinEmployeePayMapper extends Mapper<> {
        public void map(key,value) {
            String[] arrTemp = value.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            /**
             * convert either to a text format using employee_pay object or 
             * create a custom writable data type for output
             */
            String id = arrTemp[0];
            employee_pay empPay = new employee_pay();
            empPay.setFirst_name(arrName[1]);
            empPay.setLast_name(arrName[2]);
            outputKey = Pair(id, 1);
            outputValue = Pair("n", empName);
            context.write(outputKey, outputValue);
        }
    }

    /**
     * The reducer gets both the id as the key
     * and and fields empName and empPay.
     * we just append the values based on the sort & shuffling done using id
     * sorting is already
     * 
     * PROVIDING ONLY THE PSUEDOCODE AS THE ACTUAL CODE INTRODUCES MORE LINES OF CODE
     */
    public static class LeftOuterJoinReducer extends Reducer<>{
        public void reduce(keyId, customObject,context){
            /** 
             * loop through the iterator which will have the employ name and employee pay objects 
             * in sorted order based on the id grouping
             * employee pay object may not there for all scenario, hence need to do condition check
             */
             Iterator<CustomObject> iter = customObject.iterator();
             while(iter.hasNext()){
                 CustomObject obj = iterator.next();
                if(obj.getkey.equals("n")){                    
                    employeeJoinMap.put(keyId, employeeName);
                } else {
                    /**Ensure the key is present in the employeeJoinMap else dont add to the Mpa
                    get the corresponding row of employee_join table based on the key  from the hashMap*/
                    if(employeeJoinMap.contains(keyId)){ 
                        //employeejoin object could be null based on the value of the obj salary and bonus
                        employeeJoinMap.put(keyId,employeejoin);
                    }
                }
             }
        }
    }
}

