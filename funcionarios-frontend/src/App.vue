<template>
	<div id="inicio" class="container-fluid table" >
		<h4>Lista dos Funcionários</h4>
		<table>
		  <tr>
			<th>Nome</th>
			<th>Setor</th>
			<th>Salário</th>
			<th>Email</th>
			<th>Idade</th>
			<th></th>
			<th></th>
		  </tr>
		  <tbody id="event-table" >
			<tr v-for="funcionario in listaProdutos">
			  <td>{{ funcionario.nome }}</td> 
			  <td>{{ funcionario.setor.nome }}</td> 
			  <td>{{ funcionario.salario }}</td> 
			  <td>{{ funcionario.email }}</td> 
			  <td>{{ funcionario.idade }}</td>
			  <td><span @click="">&#9998;</span>
				<span  @click="deleteProduto(results, funcionario.id)">&#10006;</span>
			  </td>
			</tr>
		  </tbody>
		</table>
	  </div>
</template>

<script>
export default {
  
}
</script>

<style>

</style>
