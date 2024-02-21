import static utils.Utilities.writeFile;

import java.util.Scanner;

import org.objectweb.asm.*;

public class gen6 {
    @SuppressWarnings("deprecation")
    public static void main(String[] args){

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program6", null, "java/lang/Object",null);
        
        {
			MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(Opcodes.ALOAD, 0); //load the first local variable: this
			mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V",false);
			mv.visitInsn(Opcodes.RETURN);
			mv.visitMaxs(1,1);
			mv.visitEnd();
		}

        {
            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();
            mv.visitLdcInsn((String)"Please enter an Integer:");//instantiates the question we ask the user 
            mv.visitVarInsn(Opcodes.ASTORE,1);// stores this string in index 1
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");// creates our print stream
            mv.visitVarInsn(Opcodes.ALOAD,1);// loads the string we want to print
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);// prints our strean

            mv.visitTypeInsn(Opcodes.NEW, "java/util/Scanner");//implements our scanner class
            mv.visitInsn(Opcodes.DUP);// duplicates our scanner object to be used 
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");// creates our input stream
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);//uses our scanner to access our input stream

            mv.visitVarInsn(Opcodes.ASTORE,2);// stores our scanner object in index 2
            mv.visitVarInsn(Opcodes.ALOAD,2);// loads the scanner object to get ready for use from index 2

            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false);// has our scanner object ready to read the next integer that the user enters 

            mv.visitVarInsn(Opcodes.ISTORE,1);// stores the integer entered by the use at index 1

            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");// creates our print stream object

            mv.visitVarInsn(Opcodes.ILOAD,1);// loads the integer that our user input 
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);// prints the integer that our user input

            mv.visitLdcInsn((String)"Please enter an Double:");//instantiates our question to send to user
            mv.visitVarInsn(Opcodes.ASTORE,1);// stores the string to index 1
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");// creates a print stream object
            mv.visitVarInsn(Opcodes.ALOAD,1);// stores the string we want to print 
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);// prints our string

            mv.visitTypeInsn(Opcodes.NEW, "java/util/Scanner");// implements the scanner class
            mv.visitInsn(Opcodes.DUP);// duplicates our scanner to be used later
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");//creates our input stream object
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);//connects our scanner so that it can send an input stream to our user

            mv.visitVarInsn(Opcodes.ASTORE,2);// stores our scanner object
            mv.visitVarInsn(Opcodes.ALOAD,2);//loads the scanner object

            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextDouble", "()D", false);//allows the scanner object to accept the next double that is entered by the user

            mv.visitVarInsn(Opcodes.DSTORE,1);// stores the double that our user inputs

            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");//creates our print stream object

            mv.visitVarInsn(Opcodes.DLOAD,1);// loads the double we want to print
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);//prints our double

            mv.visitLdcInsn((String)"Please enter a Long:");//instantiates our question to ask the user
            mv.visitVarInsn(Opcodes.ASTORE,1);// stores the string in index 1
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");// creates a print stream object
            mv.visitVarInsn(Opcodes.ALOAD,1);//loads the string we want to print
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false); //prints our object

            mv.visitTypeInsn(Opcodes.NEW, "java/util/Scanner");// implements our scanner class
            mv.visitInsn(Opcodes.DUP);// duplicates our scanner object to use later
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");// creates an input stream 
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);// connects our scanner with out input stream

            mv.visitVarInsn(Opcodes.ASTORE,2);// stores the scanner object
            mv.visitVarInsn(Opcodes.ALOAD,2);//loads the scanner object

            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextLong", "()J", false);// allows the scanner object to accept the next long that the user inputs

            mv.visitVarInsn(Opcodes.LSTORE,1);// stores the long that our user inputs in index 1

            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");// creates a print stream object

            mv.visitVarInsn(Opcodes.LLOAD,1);// loads the long we want to print from index 1
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);// prints the long

            
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

       

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"program6.class");
        
        System.out.println("Done!");
    }//end main

}
