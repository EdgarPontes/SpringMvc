package br.com.tecnoticias.ecommerce.aplicacoes;

import javax.swing.JOptionPane;

public class CalculaFrete {
	double valor;
	
	public double calcula(String sigla, double pesoTotal) {
		if (pesoTotal == 0.00) {
			valor = 0.00;
		} else {
			switch (sigla) {
			case "PR":
				if (pesoTotal <= 20) {
					valor = 19.63 + (19.63 * 0.0017);
				} else {
					valor = 19.63 + (((pesoTotal - 20) * 0.50167) * 0.0017);
				}
				return valor;
			case "RS":
				if (pesoTotal <= 20) {
					valor = 23.20 + (23.20 * 0.0031);
				} else {
					valor = 23.20 + (((pesoTotal - 20) * 0.77664) * 0.0031);
				}

				return valor;
			case "SC":
				if (pesoTotal <= 20) {
					valor = 20.64 + (20.64 * 0.0031);
				} else {
					valor = 20.64 + (((pesoTotal - 20) * 0.59751) * 0.0017);
				}

				return valor;
			case "ES":
				if (pesoTotal <= 20) {
					valor = 30.88+ (30.88 * 0.0029);
				} else {
					valor = 30.88 + (((pesoTotal - 20) * 1.30717) * 0.0029);
				}

				return valor;
			case "MG":
				if (pesoTotal <= 20) {
					valor = 33.26  + (33.26 * 0.0029);
				} else {
					valor = 33.26 + (((pesoTotal - 20) * 1.32380) * 0.0029);
				}

				return valor;
			case "RJ":
				if (pesoTotal <= 20) {
					valor = 24.40 + (24.40 * 0.0029);
				} else {
					valor = 24.40 + (((pesoTotal - 20) * 0.91857) * 0.0029);
				}

				return valor;
			case "SP":
				if (pesoTotal <= 20) {
					valor = 25.10 + (25.10 * 0.0022);
				} else {
					valor = 25.10 + (((pesoTotal - 20) * 0.78170) * 0.0022);
				}

				return valor;
			case "DF":
				if (pesoTotal <= 20) {
					valor = 30.96 + (30.96 * 0.0029);
				} else {
					valor = 30.96 + (((pesoTotal - 20) * 1.27973) * 0.0029);
				}

				return valor;
			case "GO":
				if (pesoTotal <= 20) {
					valor = 41.41 + (41.41 * 0.0029);
				} else {
					valor = 41.41 + (((pesoTotal - 20) * 1.65051) * 0.0029);
				}

				return valor;
			case "MS":
				if (pesoTotal <= 20) {
					valor = 37.73 + (37.73 * 0.0029);
				} else {
					valor = 37.73 + (((pesoTotal - 20) * 1.44415) * 0.0029);
				}

				return valor;
			case "MT":
				if (pesoTotal <= 20) {
					valor = 42.55 + (42.55 * 0.0029);
				} else {
					valor = 42.55 + (((pesoTotal - 20) * 1.84547) * 0.0029);
				}

				return valor;
			case "TO":
				if (pesoTotal <= 20) {
					valor = 45.92 + (45.92 * 0.0052);
				} else {
					valor = 45.92 + (((pesoTotal - 20) * 2.12641) * 0.0052);
				}

				return valor;
			case "AL":
				if (pesoTotal <= 20) {
					valor = 51.68 + (51.68 * 0.0048);
				} else {
					valor = 51.68 + (((pesoTotal - 20) * 2.47517) * 0.0048);
				}
				return valor;
			case "BA":
				if (pesoTotal <= 20) {
					valor = 46.95 + (46.95 * 0.0048);
				} else {
					valor = 46.95 + (((pesoTotal - 20) * 2.11169) * 0.0048);
				}
				return valor;
			case "CE":
				if (pesoTotal <= 20) {
					valor = 56.40 + (56.40 * 0.0053);
				} else {
					valor = 56.40 + (((pesoTotal - 20) * 2.83861) * 0.0053);
				}
				return valor;
			case "MA":
				if (pesoTotal <= 20) {
					valor = 68.40 + (69.40 * 0.0048);
				} else {
					valor = 69.40 + (((pesoTotal - 20) * 3.45860) * 0.0048);
				}
				return valor;
			case "PB":
				if (pesoTotal <= 20) {
					valor = 55.37 + (55.37 * 0.0048);
				} else {
					valor = 55.37 + (((pesoTotal - 20) * 2.75952) * 0.0048);
				}
				return valor;
			case "PE":
				if (pesoTotal <= 20) {
					valor = 54.35 + (54.35 * 0.0048);
				} else {
					valor = 54.35 + (((pesoTotal - 20) * 2.68043) * 0.0048);
				}
				return valor;
			case "PI":
				if (pesoTotal <= 20) {
					valor = 69.40 + (69.40 * 0.0048);
				} else {
					valor = 69.40 + (((pesoTotal - 20) * 3.45860) * 0.0048);
				}
				return valor;
			case "RN":
				if (pesoTotal <= 20) {
					valor = 55.37 + (55.37 * 0.0048);
				} else {
					valor = 55.37 + (((pesoTotal - 20) * 2.75952) * 0.0048);
				}
				return valor;
			case "SE":
				if (pesoTotal <= 20) {
					valor = 41.58 + (41.58 * 0.0048);
				} else {
					valor = 41.58 + (((pesoTotal - 20) * 1.89867) * 0.0048);
				}
				return valor;
			case "AC":
				if (pesoTotal <= 20) {
					valor = 46.97 + (46.97 * 0.0063);
				} else {
					valor = 46.97 + (((pesoTotal - 20) * 2.51375) * 0.0063);
				}
				return valor;
			case "AM":
				if (pesoTotal <= 20) {
					valor = 48.60 + (48.60 * 0.0063);
				} else {
					valor = 48.60 + (((pesoTotal - 20) * 2.65003) * 0.0063);
				}
				return valor;
			case "AP":
				if (pesoTotal <= 20) {
					valor = 138.51 + (138.51 * 0.0297);
				} else {
					valor = 138.51 + (((pesoTotal - 20) * 5.22526) * 0.0297);
				}
				return valor;
			case "PA":
				if (pesoTotal <= 20) {
					valor = 51.80 + (51.80 * 0.0056);
				} else {
					valor = 51.80 + (((pesoTotal - 20) * 2.71707) * 0.0056);
				}
				return valor;
			case "RO":
				if (pesoTotal <= 20) {
					valor = 51.80 + (51.80 * 0.0056);
				} else {
					valor = 51.80 + (((pesoTotal - 20) * 2.71707) * 0.0056);
				}
				return valor;
			case "RR":
				if (pesoTotal <= 20) {
					valor = 59.28 + (59.28 * 0.0063);
				} else {
					valor = 59.28 + (((pesoTotal - 20) * 3.34012) * 0.0063);
				}
				return valor;

			default:
				JOptionPane.showMessageDialog(null, "Estado Não localizado para calcular frete");
				break;
			}
		}
		return valor;
	}
}
