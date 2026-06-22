package mystack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {

    private MyStack stack;

    // Inicializa uma nova pilha antes de cada teste
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

        // Como é uma pilha (LIFO), o último a entrar deve ser o primeiro a sair
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
        assertEquals("Item Fixo", stack.pop(), "O pop subsequente deve retornar o mesmo item.");
    }

    @Test
    void testPopOnEmptyStack() {
        assertNull(stack.pop(), "O pop em uma pilha vazia deve retornar null.");
    }

    @Test
    void testPeekOnEmptyStack() {
        assertNull(stack.peek(), "O peek em uma pilha vazia deve retornar null.");
    }

    @Test
    void testPrintOutput() {
        // Redireciona a saída do console para podermos testar o que o método print() escreve
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        stack.push("A");
        stack.push("B");
        stack.push("C");
        
        stack.print();

        // Verifica se a formatação impressa está exatamente igual ao esperado
        assertEquals("C -> B -> A -> null.\n", outContent.toString());

        // Restaura a saída padrão do sistema
        System.setOut(originalOut);
    }
}