import { http } from './config'

export default {

    listar:() => {
        return http.get('funcionarios')
    },

    deletar:(id) => {
        return http.delete('funcionarios/' + id)
    },

    salvar:(funcionario) => {
        return http.post('funcionarios', funcionario)
    },

    atualizar:(funcionario) => {
        return http.put('funcionarios', funcionario)
    }
}