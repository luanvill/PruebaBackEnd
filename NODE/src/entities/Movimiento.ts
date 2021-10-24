import {
    BeforeInsert,
    Column,
    Entity,
    PrimaryGeneratedColumn,
} from "typeorm";


@Entity("MOVIMIENTO")
export class Movimiento{

    @PrimaryGeneratedColumn({name:"SECUENCIA"})
    secuencia: number;

    @Column({ name: "CODIGO_ITEM" })
    codigoItem: number;

    @Column({ name: "CODIGO_PROVEEDOR" })
    codigoProveedor: number;

    @Column({ name: "FECHA_HORA_MOVIMIENTO" })
    fechaHoraMovimiento: Date;

    @Column({ name: "TIPO_MOVIMIENTO" })
    tipoMovimiento: string;

    @Column({ name: "CANTIDAD" })
    cantidad: number;

    @Column({ name: "USUARIO_BODEGA" })
    usuarioRegistro: string;

    @Column({ name: "FECHA_REGISTRO" })
    fechaRegistro: Date;

    @BeforeInsert()
    beforeInsertActions() {    
        this.usuarioRegistro = "SYSTEM";
        this.fechaRegistro = new Date();
    }
}