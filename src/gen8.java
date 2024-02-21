import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

public class gen8 {
    public static void main(String[] args){

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program8", null, "java/lang/Object",null);
        
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
            Label endLabel = new Label();// creates our endLabel that we will use later
            Label comp1 = new Label();// creates our comp1 label we will use later
            Label comp2 = new Label();// creates our comp2 label we will use later

            mv.visitLdcInsn(-10);// instantiates our integer 

            mv.visitJumpInsn(Opcodes.IFGT,comp1);// compares our integer to 0, if it is greater than, it will go to our comparison 1 label

            mv.visitJumpInsn(Opcodes.GOTO,comp2);//jumps to our comp2 label

            
            mv.visitLabel(comp1);// visits our comp1 label
            mv.visitLdcInsn((String)"The number is positive");//instatiates our string we want to print
            mv.visitVarInsn(Opcodes.ASTORE,1);// stores the string in index 1
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");// creates our print stream object
            mv.visitVarInsn(Opcodes.ALOAD,1);// loads our string we want to print
           mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);// prints the string we want
           mv.visitJumpInsn(Opcodes.GOTO, endLabel);// visits our endlabel label we created

           mv.visitLabel(comp2);// visits our comp2 label
           mv.visitLdcInsn((String)"The number is negative");// instantiates our string we want to print
           mv.visitVarInsn(Opcodes.ASTORE,1);// stores the string we want to use in index 1
           mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");// creates our print stream
           mv.visitVarInsn(Opcodes.ALOAD,1);// loads our string we want to print
          mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);// prints our string
          mv.visitJumpInsn(Opcodes.GOTO, endLabel);// jumps to the endLabel label



            mv.visitLabel(endLabel);//visits our endLabel label
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

       

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"program8.class");
        
        System.out.println("Done!");
    }//end main

}