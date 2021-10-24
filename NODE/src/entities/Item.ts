import {
    BeforeInsert,
    Column,
    Entity,
    PrimaryGeneratedColumn,
} from "typeorm";


@Entity("ITEM")
export class Item{

    @PrimaryGeneratedColumn({ name: "CODIGO_ITEM" })
    codigoItem: number;

    @Column({ name: "GRUPO" })
    grupo: string;

    @Column({ name: "SUBGRUPO" })
    subGrupo: number;

    @Column({ name: "DESCRIPCION_ITEM" })
    descripcionItem: string;

    @Column({ name: "STOCK" })
    stock: number;

    @Column({ name: "PRECIO" })
    precio: number;

    @Column({ name: "CODIGO_BODEGA" })
    codigoBodega: number;

    @Column({ name: "ESTADO" })
    estado: string;   

    @Column({ name: "USUARIO_REGISTRO" })
    usuarioRegistro: string;

    @Column({ name: "FECHA_REGISTRO" })
    fechaRegistro: Date;


    @BeforeInsert()
    beforeInsertActions() {
        this.descripcionItem = this.descripcionItem.toUpperCase();
        this.usuarioRegistro = "SYSTEM";
        this.fechaRegistro = new Date();
    }
}