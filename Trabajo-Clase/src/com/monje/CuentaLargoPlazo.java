package com.monje;

public class CuentaLargoPlazo extends Cuenta {
    public final double INTERES_RETIRO = .05;

    public boolean retirar(double monto){
        monto += (monto*INTERES_RETIRO);
        return super.retirar(monto);
    }
}
