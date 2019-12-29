package line;

import java.io.*;
import java.util.Scanner;

class MemCopyImpl
{
    
    private static void memcpy(byte[] v, int dest, int src, int size) {
        //TODO: Implement
    	System.arraycopy(v, src, v, dest, size);
    }
    
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in).useRadix(10);
        int arrSize  = scanner.nextInt();
        scanner.nextLine();

        byte[] bytes = new byte[arrSize];
        for(int i=0;i<arrSize;i++){
            bytes[i] = Integer.valueOf(scanner.nextInt()).byteValue();
        }
        scanner.nextLine();
        
        int dest = scanner.nextInt();
        int src = scanner.nextInt();
        int size = scanner.nextInt();
        scanner.close();
        
        try {
            memcpy(bytes, dest, src, size);
        } catch (Exception e) {
            //ignore
        }
        printBytes(bytes, System.out);
    }
    
    private static void printBytes(byte[] bytes, PrintStream out) {
        for (byte item : bytes) {
            out.print(Byte.toUnsignedInt(item));
            out.print(' ');
        }
    }
   
}

