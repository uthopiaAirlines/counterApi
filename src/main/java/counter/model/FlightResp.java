package counter.model;

import java.util.List;

public class FlightResp {

	private List<Flight> data;
	private long totalFlights;
	private long totalFiltered;
	
	
	public List<Flight> getData() {
		return data;
	}
	public void setData(List<Flight> data) {
		this.data = data;
	}
	public long getTotalFlights() {
		return totalFlights;
	}
	public void setTotalFlights(long totalFlights) {
		this.totalFlights = totalFlights;
	}
	public long getTotalFiltered() {
		return totalFiltered;
	}
	public void setTotalFiltered(long totalFiltered) {
		this.totalFiltered = totalFiltered;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + (int) (totalFiltered ^ (totalFiltered >>> 32));
		result = prime * result + (int) (totalFlights ^ (totalFlights >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightResp other = (FlightResp) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (totalFiltered != other.totalFiltered)
			return false;
		if (totalFlights != other.totalFlights)
			return false;
		return true;
	}
	
	
}
