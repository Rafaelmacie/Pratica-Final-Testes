package mystack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {

    private MyStack stack;

    @BeforeEach
    void setUp() {
        stack = new MyStack();
    }

    @Test
    void testIsEmptyOnNewStack() {
        assertTrue(stack.isEmpty(), "A pilha deve estar vazia ao ser inicializada.");
    }

    @Test
    void testPushMakesStackNotEmpty() {
        stack.push("Item 1");
        assertFalse(stack.isEmpty(), "A pilha não deve estar vazia após um push.");
    }

    @Test
    void testPushAndPopOrder() {
        stack.push("Primeiro");
        stack.push("Segundo");
        stack.push("Terceiro");

        assertEquals("Terceiro", stack.pop());
        assertEquals("Segundo", stack.pop());
        assertEquals("Primeiro", stack.pop());
        assertTrue(stack.isEmpty(), "A pilha deve ficar vazia após remover todos os itens.");
    }

    @Test
    void testPeekDoesNotRemoveItem() {
        stack.push("Item Fixo");
        
        assertEquals("Item Fixo", stack.peek(), "O peek deve retornar o item do topo.");
        assertFalse(stack.isEmpty(), "O peek não deve remover o item da pilha.");
        assertEquals("Item Fixo", stack.pop(), "O pop subsequente deve retornar o mesmo item e removê-lo");
        assertTrue(stack.isEmpty(), "A pilha deve estar vazia");
    }

    @Test
    void testPeekOnEmptyStack(){
        assertEquals("Pilha vazia.", stack.peek());
    }

    @Test
    void testPopOnEmptyStack() {
        assertEquals("Pilha vazia.", stack.pop());
    }

    @Test
    void testPrintOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        stack.push("A");
        stack.push("B");
        stack.push("C");
        
        stack.print();

        assertEquals("C -> B -> A -> null.\n", outContent.toString());

        System.setOut(originalOut);
    }
}