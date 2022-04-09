export interface Loja{
    id:number,
	nome:string,
	representante: Representante,
	conta: Conta,
	transacoes: Transacao[]
}

export interface Representante{
    id:number,
    nome:string
}

export interface Conta{
    id: number,
    saldo: number
}

export interface Transacao{
    id: number,
    dataHora: string,
    valor: number,
    tipoTransacao: TipoTransacao,
    beneficiario: Beneficiario,
    cartao: Cartao
}

export interface TipoTransacao{
    tipo:string,
    natureza:string
}

export interface Beneficiario{
    id: number,
    cpf: number
}

export interface Cartao{
    id: number,
    numero: string
}