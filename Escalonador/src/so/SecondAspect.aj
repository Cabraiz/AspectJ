package so;
import java.util.ArrayList;
import Beans.Processo;
import so.RoundRobin;

privileged aspect SecondAspect {
	
	pointcut CallProcessoRR(RoundRobin rr, ArrayList<Processo> a, ArrayList<Processo> b): 
		target(rr) &&
		args(a,b) && call(void RoundRobin.Run(ArrayList<Processo>, ArrayList<Processo>));
	
	Object around(RoundRobin rr, ArrayList<Processo> a, ArrayList<Processo> b) : 
		CallProcessoRR(rr,a,b) {
			if (!rr.threadGo.isAlive()) {
				return proceed(rr,a,b);
			}else{
				return false;
			}
		}
	
	
	pointcut CallProcessoSJF(SJF sjf, ArrayList<Processo> a, ArrayList<Processo> b): 
		target(sjf) &&
		args(a,b) && call(void SJF.Run(ArrayList<Processo>,ArrayList<Processo>));
	
	Object around(SJF sjf, ArrayList<Processo> a, ArrayList<Processo> b) : 
		CallProcessoSJF(sjf,a,b) {
			if (!sjf.threadGo.isAlive()) {
				return proceed(sjf,a,b);
			}else{
				return false;
			}
		}
	
	
	pointcut CallProcessoLTG(LTG ltg, ArrayList<Processo> a, ArrayList<Processo> b): 
		target(ltg) &&
		args(a,b) && call(void LTG.Run(ArrayList<Processo>,ArrayList<Processo>));
	
	Object around(LTG ltg, ArrayList<Processo> a, ArrayList<Processo> b) : 
		CallProcessoLTG(ltg,a,b) {
			if (!ltg.threadGo.isAlive()) {
				return proceed(ltg,a,b);
			}else{
				return false;
			}
		}
}
	
	
