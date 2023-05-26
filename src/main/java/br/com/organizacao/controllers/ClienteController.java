package br.com.organizacao.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.organizacao.entities.Cliente;
import br.com.organizacao.repositores.IClienteRepository;
import br.com.organizacao.request.ClientePostRequest;
import br.com.organizacao.request.ClientePutRequest;
import br.com.organizacao.responses.ClienteGetResponse;
import io.swagger.annotations.ApiOperation;

@Controller
@Transactional
public class ClienteController {
	@Autowired
	private IClienteRepository clienteRepository;

	// endereco do serviço

	private static final String ENDPOINT = "/api/cliente";

	// mérodo para realizar o cadastro

	@ApiOperation("Realizar o Cadastro")
	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
	@CrossOrigin
	public ResponseEntity<String> post(@RequestBody ClientePostRequest request) {
		try {
			Cliente cliente = new Cliente();
			cliente.setNome(request.getNome()) ;
			cliente.setCpf(request.getCpf());
			cliente.setEmail(request.getEmail());
			clienteRepository.save(cliente);

			return ResponseEntity
					.status(HttpStatus.OK)
					.body("Produto cadastrado com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
		}

	}
	@ApiOperation("Serviço para consultar.")
	@RequestMapping(value = ENDPOINT, method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<List<ClienteGetResponse>> get() {

		List<ClienteGetResponse> response = new ArrayList<ClienteGetResponse>();
		
		for(Cliente cliente : clienteRepository.findAll()) {
			
			ClienteGetResponse item = new ClienteGetResponse();
			
			item.setIdCliente(cliente.getIdCliente());
			item.setNome(cliente.getNome());
			item.setCpf(cliente.getCpf());
			item.setEmail(cliente.getEmail());
			
			response.add(item);
		}
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	} 
	
	//método para consultar 1 produto baseado no ID
		@ApiOperation("Serviço para consultar 1 Cliente através do ID.")
		@RequestMapping(value = ENDPOINT + "/{idCliente}", method = RequestMethod.GET)
		@CrossOrigin
		public ResponseEntity<ClienteGetResponse> getById(@PathVariable("idCliente") Integer idCliente) {
			
			//consultar o produto no banco de dados atraves do ID
			Optional<Cliente> item = clienteRepository.findById(idCliente);
			
			//verificar se o produto não foi encontrado
			if(item.isEmpty()) {			
				return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body(null);
			}
			else {
				
				ClienteGetResponse response = new ClienteGetResponse();
				Cliente cliente = item.get();
				
				response.setIdCliente(cliente.getIdCliente());
				response.setNome(cliente.getNome());
				response.setCpf(cliente.getCpf());
				response.setEmail(cliente.getEmail());
				
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(response);
			}		
		}
			
			// método para realizar o serviço de exclusão do produto
			@ApiOperation("Serviço para exclusão de um cliente.")
			@RequestMapping(value = ENDPOINT + "/{idCliente}", method = RequestMethod.DELETE)
			@CrossOrigin
			public ResponseEntity<String> delete(@PathVariable("idCliente") Integer idCliente) {
				
				try {			
					//consultar o produto no banco de dados atraves do ID
					Optional<Cliente> item = clienteRepository.findById(idCliente);
					
					//verificar se o produto não foi encontrado
					if(item.isEmpty()) {
						
						return ResponseEntity
								.status(HttpStatus.BAD_REQUEST)
								.body("Produto não encontrado, por favor verifique.");
					}
					else {
						
						Cliente cliente = item.get();
						clienteRepository.delete(cliente);
						
						return ResponseEntity
								.status(HttpStatus.OK)
								.body("Produto excluído com sucesso.");
					}
				}
				catch(Exception e) {
				
					return ResponseEntity
							.status(HttpStatus.INTERNAL_SERVER_ERROR)
							.body("Erro: " + e.getMessage());
				}
			}
			@ApiOperation("Serviço para atualização dos dados de um produto.")
			@RequestMapping(value = ENDPOINT, method = RequestMethod.PUT)
			@CrossOrigin
			public ResponseEntity<String> put(@RequestBody ClientePutRequest request) {
				
				try {
					
					Optional<Cliente> item = clienteRepository.findById(request.getIdCliente());
					
					if(item.isEmpty()) {
						
						return ResponseEntity
								.status(HttpStatus.BAD_REQUEST)
								.body("Produto não encontrado, por favor verifique.");
					}
					else {
						
						Cliente cliente = item.get();
						
						cliente.setNome(request.getNome());
						cliente.setCpf(request.getCpf());
						cliente.setEmail(request.getEmail());
					
						clienteRepository.save(cliente);
						
						return ResponseEntity
								.status(HttpStatus.OK)
								.body("Produto atualizado com sucesso.");
					}
				}
				catch(Exception e) {
				
					return ResponseEntity
							.status(HttpStatus.INTERNAL_SERVER_ERROR)
							.body("Erro: " + e.getMessage());
				}
			}

		
		
		

}
