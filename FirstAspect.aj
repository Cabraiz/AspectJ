package so;

import java.text.SimpleDateFormat;

import Beans.Processo;

public aspect FirstAspect {
	SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:S a");
	pointcut CallProcesso(Processo p, int ID): 
		target(p) && execution(Processo.new(int)) && args(ID);
	after(Processo p, int ID): CallProcesso(p, ID){
		System.out.println("ID: "+ ID + " ExeTime: "+ p.getExe()
				+ " DeadTime: " + sdf.format(p.getDeadline().getTime())
				+ " Prioridade :" + p.getPrior());
	}
}
