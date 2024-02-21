import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class gen1 {
    public static void main(String[] args){

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program1", null, "java/lang/Object",null);
        
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
            mv.visitLdcInsn((Double)173.43);//the double being instantiated
            mv.visitVarInsn(Opcodes.DSTORE,1);//storing the double to index 1
            mv.visitLdcInsn((Double)45.56);// second double being instantiated
            mv.visitVarInsn(Opcodes.DSTORE,3);// second double being stored to index 3
            mv.visitVarInsn(Opcodes.DLOAD,1);//loading the double stored at index 1
            mv.visitVarInsn(Opcodes.DLOAD,3);// loading the double at index 3
            mv.visitInsn(Opcodes.DMUL);// multiplying the 2 doubles 
            mv.visitVarInsn(Opcodes.DSTORE,5);//storing the product of our multiplication
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");//getting our printstrean object
            mv.visitVarInsn(Opcodes.DLOAD, 5);//loading what we want to print
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);//finilizing the print of our product

            mv.visitLdcInsn((Integer)173);//the Integer being instantiated
            mv.visitVarInsn(Opcodes.ISTORE,1);//integer being stored to index 1
            mv.visitLdcInsn((Integer)45);// the second integer being instantiated 
            mv.visitVarInsn(Opcodes.ISTORE,3);//The secnd integer being stored to index 3
            mv.visitVarInsn(Opcodes.ILOAD,1);//loading the integer stored at index 1
            mv.visitVarInsn(Opcodes.ILOAD,3);//loading the integer stored at index 3
            mv.visitInsn(Opcodes.IMUL);//multiplying our 2 integers
            mv.visitVarInsn(Opcodes.ISTORE,5);//storing our product 
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");//creating our print stream object
            mv.visitVarInsn(Opcodes.ILOAD, 5);//loading our product stored at index 5
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);//prints our product

            mv.visitLdcInsn(173.5f);//The float being instantiated
            mv.visitVarInsn(Opcodes.FSTORE,1);//float being stored to index 1
            mv.visitLdcInsn(45.8f);// second float being instantiated
            mv.visitVarInsn(Opcodes.FSTORE,3);// second float being stored to index 3
            mv.visitVarInsn(Opcodes.FLOAD,1);// loading the first float stored in index 1
            mv.visitVarInsn(Opcodes.FLOAD,3);// loading the second float stored in index 3
            mv.visitInsn(Opcodes.FMUL);//multiply our 2 float numbers
            mv.visitVarInsn(Opcodes.FSTORE,5);//storing the product of our multiplication
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");//creates our print stream object
            mv.visitVarInsn(Opcodes.FLOAD, 5);//loads our product stored in index 5
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);//prints our product

            mv.visitLdcInsn(173L);//the long being instantiated
            mv.visitVarInsn(Opcodes.LSTORE,1);// loading the long to index 1
            mv.visitLdcInsn(45L);// the second long being instantiated
            mv.visitVarInsn(Opcodes.LSTORE,3);// storing our second long in index 3
            mv.visitVarInsn(Opcodes.LLOAD,1);//loading our long stored in index 1
            mv.visitVarInsn(Opcodes.LLOAD,3);//loading our long stored in index 3
            mv.visitInsn(Opcodes.LMUL);// multiplying our 2 longs
            mv.visitVarInsn(Opcodes.LSTORE,5);//storing our product
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");//creates our print stream object
            mv.visitVarInsn(Opcodes.LLOAD, 5);// loads our product stored in index 5
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);//prints our product





            
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

       

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"program1.class");
        
        System.out.println("Done!");
    }//end main

}
