package teste;

import java.util.List;

import br.com.livro.domain.Carro;
import br.com.livro.domain.CarroService;
import junit.framework.TestCase;

public class CarroTest extends TestCase {

	public CarroService service = new CarroService();

	public void testListaCarros() {
		List<Carro> carros = service.getCarros();
		assertNotNull(carros);
		// valida se encontrou algo
		assertTrue(carros.size() > 0);

		Carro tucker = service.findByName("Tucker 1948").get(0);
		assertEquals("Tucker 1948", tucker.getNome());

		Carro ferrari = service.findByName("Ferrari FF").get(0);
		assertEquals("Ferrari FF", ferrari.getNome());
	}

	public void testSalvarDeletarCarro() {
		Carro c = new Carro();
		c.setNome("Teste");
		c.setDesc("TesteDesc");
		c.setUrlFoto("TesteFoto");
		c.setUrlVideo("TesteVideo");
		c.setLatitude("TesteLatitude");
		c.setLongitude("TesteLongitude");
		c.setTipo("TesteTipo");
		service.save(c);
		// id do carro salvo

		Long id = c.getId();

		assertNotNull(id);
		// busca no banco de dados para confirmar que o carro foi salvo

		c = service.getCarro(id);
		assertEquals("Teste", c.getNome());
		assertEquals("TesteDesc", c.getDesc());
		assertEquals("TesteFoto", c.getUrlFoto());
		assertEquals("TesteVideo", c.getUrlVideo());
		assertEquals("TesteLatitude", c.getLatitude());
		assertEquals("TesteLongitude", c.getLongitude());
		assertEquals("TesteTipo", c.getTipo());
		// atualiza o carro
		c.setNome("Teste UPDATE");
		service.save(c);
		// busca o carro novamente (ATUALIZADO)
		c = service.getCarro(id);
		assertEquals("Teste UPDATE", c.getNome());
		// deleta o carro
		service.delete(id);
		// busca novamente
		c = service.getCarro(id);
		// DESTA VEZ NAO EXISTE MAIS
		assertNull(c);

	}
}
