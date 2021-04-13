import { http } from './config'

export default {

    listar:() => {
        return http.get('funcionarios')
    },

    deletar:(funcionario) => {
        return http.delete('produto', {data: funcionario})
    },

    salvar:(funcionario) => {
        return http.post('funcionarios', funcionario)
    }
}