import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

public class gen4{
    public static void main(String[] args){

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program4", null, "java/lang/Object",null);
        
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
            Label comp1 = new Label();// creates the label for our first comparison
            Label comp1Print = new Label();// creates the label for our first print 
            Label comp2 = new Label();// creates the label for our second comparison
            Label comp2Print = new Label();//creates the label for our second print 
            Label comp3 = new Label();// creates the label for our third comparison
            Label comp3Print = new Label();// creates the label for our third print 


            mv.visitLdcInsn((Integer)41);//instantiates our first integer
            mv.visitVarInsn(Opcodes.ISTORE,1);// stores our first integer in index 1
            mv.visitLdcInsn((Integer)173);// instantiates our second integer
            mv.visitVarInsn(Opcodes.ISTORE,3);//stores our second integer to index 3
            mv.visitVarInsn(Opcodes.ILOAD,1);// loads our number stored in index 1
            mv.visitVarInsn(Opcodes.ILOAD,3);// loads our number stored in index 3
            mv.visitJumpInsn(Opcodes.IF_ICMPGT,comp1);// compares our 2 integers and if integer 1 is larger than it goes to our Label of comp1
            mv.visitVarInsn(Opcodes.ILOAD, 3);//loads our second number that we know is larger based off comparisons
            mv.visitJumpInsn(Opcodes.GOTO, comp1Print);//jumps to our label that prints our comparision

            mv.visitLabel(comp1);//visits our label we created
            mv.visitVarInsn(Opcodes.ILOAD,1);//loads the number we know is larger based on comparison
            mv.visitLabel(comp1Print);// visits our label 
            mv.visitVarInsn(Opcodes.ISTORE, 5);// stores our number we want to print
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");// creates our print stream object
            mv.visitVarInsn(Opcodes.ILOAD, 5);// loads the number we want to print
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);// prints our number
            
            

            mv.visitLdcInsn((short) 173);//Instantiates our first short
            mv.visitVarInsn(Opcodes.ISTORE,1);// stores the short in index 1
            mv.visitLdcInsn( (short) 45);// instantiates our second short
            mv.visitVarInsn(Opcodes.ISTORE,3);//stores the short in index 3
            mv.visitVarInsn(Opcodes.ILOAD,1);// loads the short stored in index 1
            mv.visitVarInsn(Opcodes.ILOAD,3);//loads the short stored in index 3
            mv.visitJumpInsn(Opcodes.IF_ICMPGT,comp2);// compares the 2 shorts to see which one is bigger, and then goes to our label we made
            mv.visitVarInsn(Opcodes.ILOAD, 3);// loads the second number which we know is larger based on the comparison
            mv.visitJumpInsn(Opcodes.GOTO, comp2Print);//jumps to our comp2print label we made 

            mv.visitLabel(comp2);// visits our comp2 label
            mv.visitVarInsn(Opcodes.ILOAD,1);//loads the number stored in index one which we know is larger based on our comparison we did
            mv.visitLabel(comp2Print);// visits our comp2print label
            mv.visitVarInsn(Opcodes.ISTORE, 5);//stores the number we want to print
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");// creates our print stream object
            mv.visitVarInsn(Opcodes.ILOAD, 5);//loads our number stored at index 5
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);//prints our number

            

            mv.visitLdcInsn(173L);// instantiates our first long
            mv.visitVarInsn(Opcodes.LSTORE,1);// stores the long in index 1
            mv.visitLdcInsn(45L);// instantiates our second long
            mv.visitVarInsn(Opcodes.LSTORE,3);// stores the long in index 3
            mv.visitVarInsn(Opcodes.LLOAD,1);// loads the long stored in index 1
            mv.visitVarInsn(Opcodes.LLOAD,3);// loads the long stored in index 3
            mv.visitInsn(Opcodes.LCMP);// since it is comparisons between longs it has its own comparison
            mv.visitJumpInsn(Opcodes.IFGT, comp3);// once the longs get compared we see which one is greater and go from there
            mv.visitVarInsn(Opcodes.LLOAD, 3);// loads the long in index 3 which we know is larger based on comparison
            mv.visitJumpInsn(Opcodes.GOTO, comp3Print);// jumps to our comp3print label

            mv.visitLabel(comp3);//visits our comp3 label
            mv.visitVarInsn(Opcodes.LLOAD, 1);//loads our long in index 1, which we know is larger based on the comparison
            mv.visitLabel(comp3Print);// visits our comp3print label
            mv.visitVarInsn(Opcodes.LSTORE, 5);// stores our number we want to print
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");// creates our print stream object
            mv.visitVarInsn(Opcodes.LLOAD, 5);// loads our number we want to print
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);// prints our long


            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

       

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"program4.class");
        
        System.out.println("Done!");
    }//end main

}
