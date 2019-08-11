package com.ctci;

public class SpaceReplacement {
    public static void main(String[] args){
        String sid = "moj and aa";

        // By without using split function

        // By Using Split function
        SpaceReplacement mains = new SpaceReplacement();
        System.out.println("output: "+ mains.replaceWithOutSplit(sid));
    }
    public String replaceWithOutSplit(String input){
        String output = "";
        // can be done in two ways: use split() and get the length of the list
        // or use for loop and count the spaces
        int counter = 0;
        char[] charIn = input.toCharArray();
        for(int i=0;i<charIn.length;i++){
            if(charIn[i] == " ".charAt(0)){
                counter++;
            }
        }
        int finalLen = charIn.length + (2* counter);
        char[] outputChar = new char[finalLen];
        int origCounter = counter;
        int inputCounter = charIn.length-1;
        for(int j=(finalLen-1); j>=0;){
            if(charIn[inputCounter]!=" ".charAt(0)){
                outputChar[j] = charIn[inputCounter];
            }else if(origCounter>0) {
                outputChar[j] = "0".charAt(0);
                j--;
                outputChar[j] = "2".charAt(0);
                j--;
                outputChar[j] = "%".charAt(0);
                origCounter--;
            }
            inputCounter --;
            j--;
            System.out.println("origCounter: "+origCounter+ "j: " + j);
        }
        return new String(outputChar);
    }

    public String replace(String input){
        String[] inputs = input.split(" ");
        StringBuilder output = new StringBuilder();
        for(int i=0; i<inputs.length; i++){
            if(i != inputs.length - 1 ){
                output.append(inputs[i] + "%20");
            }else{
                output.append(inputs[i]);
            }
        }
        return output.toString();
    }
    public String CustomReplace(String input){
        return " ";
    }
}
