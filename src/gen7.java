import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class gen7 {
    public static void main(String[] args){

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program7", null, "java/lang/Object",null);
        
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
            Label endLabel = new Label();// creates our label we will use later to end our program
            Label loop = new Label();// creates our label we will use later to loop our program
           

            mv.visitInsn(Opcodes.ICONST_0);// instantiates a 0
            mv.visitVarInsn(Opcodes.ISTORE,1);// stores the 0 in index 1
            mv.visitLabel(loop);// visits our loop label
            mv.visitVarInsn(Opcodes.ILOAD,1);// loads the 0 stored here

            mv.visitIntInsn(Opcodes.BIPUSH, 10);// pushes 10 onto our stack

            mv.visitJumpInsn(Opcodes.IF_ICMPGE,endLabel);// compares our top number in our stack with the second one, and if it is larger than it continues on, but if it is smaller than it visits the end label
          
            mv.visitIincInsn(1, 1);// increases the 0 in index 1 by 1
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");// creates a print stream object
            mv.visitVarInsn(Opcodes.ILOAD, 1);// loads the integer in index 1
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);// prints the integer
            mv.visitJumpInsn(Opcodes.GOTO, loop);// jumps back up to our visit loop label in order to create our loop


            mv.visitLabel(endLabel);// visits our end label, which leads to the end of our program ending
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

       

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"program7.class");
        
        System.out.println("Done!");
    }//end main

}
