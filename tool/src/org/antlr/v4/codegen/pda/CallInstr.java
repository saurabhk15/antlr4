package org.antlr.v4.codegen.pda;

import org.antlr.runtime.Token;
import org.antlr.v4.codegen.PDABytecodeGenerator;
import org.antlr.v4.runtime.pda.Bytecode;

/** */
public class CallInstr extends Instr {
	public Token token;
	public int target;
	public CallInstr(Token token) { this.token = token; }
	public short opcode() { return Bytecode.CALL; };
	public int nBytes() { return 1+Bytecode.ADDR_SIZE; }
	public void write(byte[] code) {
		super.write(code);
		PDABytecodeGenerator.writeShort(code, addr+1, (short)target);
	}

	@Override
	public String toString() {
		return addr+":CallInstr{" +
			   "target=" + target +
			   '}';
	}
}