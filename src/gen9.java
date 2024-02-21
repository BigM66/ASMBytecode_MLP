import static utils.Utilities.writeFile;

import java.util.Scanner;

import org.objectweb.asm.*;

public class gen9 {
    @SuppressWarnings("deprecation")
    public static void main(String[] args){

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program9", null, "java/lang/Object",null);
        
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

            Label loop = new Label();// creates our loop label
            Label endLabel = new Label();// creates our end label
            Label accum= new Label();// creates our accum label


           

            mv.visitInsn(Opcodes.ICONST_0);// instantiates a 0 
            mv.visitVarInsn(Opcodes.ISTORE,1);// stores the 0 in index 1 for use later

            mv.visitInsn(Opcodes.ICONST_0);// instantiates a 0
            mv.visitVarInsn(Opcodes.ISTORE,2);// stores the 0 in index 2 for use later

            mv.visitInsn(Opcodes.ICONST_0);// instantiates a 0
            mv.visitVarInsn(Opcodes.ISTORE,6);// stores the 0 in index 6 for use later

            mv.visitLabel(loop);// visits our loop label

            mv.visitVarInsn(Opcodes.ILOAD,1);// loads the integer stored in index 1, it is a 0

            mv.visitIntInsn(Opcodes.BIPUSH, 5);// pushes the number 5 on top of our stack

            mv.visitJumpInsn(Opcodes.IF_ICMPGE,endLabel);// compares the number 5 to our second item on the stack, if the item we compare is greater than our second then it jumps to the end label
          
            mv.visitIincInsn(1, 1);// increases our integers stored in index 1 by 1


            mv.visitLdcInsn((String)"Please enter an Integer:");//instantiates our string
            mv.visitVarInsn(Opcodes.ASTORE,3);// loads the string in index 3
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");// creates a print stream object
            mv.visitVarInsn(Opcodes.ALOAD,3);// loads the string in index 3
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);// prints our string

            mv.visitTypeInsn(Opcodes.NEW, "java/util/Scanner");// creates our scanner object
            mv.visitInsn(Opcodes.DUP);// duplicates the scanner object for use later
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");// creates an input stream object
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);// connects our scanner to the input stream

            mv.visitVarInsn(Opcodes.ASTORE,4);// stores our scanner object
            mv.visitVarInsn(Opcodes.ALOAD,4);// loads the scanner object

            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false);// allows our scanner to accpet the integer that the user inputs

            mv.visitVarInsn(Opcodes.ISTORE,5);// stores the users integer in index 5

            mv.visitJumpInsn(Opcodes.GOTO,accum);// jumps to our accum label

           
            mv.visitLabel(accum);// visits our accum label

            mv.visitVarInsn(Opcodes.ILOAD,5);// loads what integer is in our index 5 spot, which is the users input
            mv.visitVarInsn(Opcodes.ILOAD,6);// loads what integer is in our index 6 spot, which is the sum this far 
            mv.visitInsn(Opcodes.IADD);// adds our 2 integrs, which are the sum and the new user input
            mv.visitVarInsn(Opcodes.ISTORE,6);// stores our sum in index 6
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");// creates a print stream
            mv.visitVarInsn(Opcodes.ILOAD,6);// loads our sum
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);// prints our sum
            mv.visitJumpInsn(Opcodes.GOTO, loop);// jumps to our loop label



            mv.visitLabel(endLabel);// jumps to our end label to end program
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

       

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"program9.class");
        
        System.out.println("Done!");
    }//end main

}