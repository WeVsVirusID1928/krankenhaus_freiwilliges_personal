import { useEffect, useState } from 'react';

export function usePingStatus() {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch('http://localhost:1357/ping')
      .then(response => response.json())
      .then(apiResponse => setData(apiResponse))
      .then(() => setLoading(false))
      .catch(err => {
        setLoading(false);
        setError(err);
      });
  }, []);

  return [data, loading, error];
}
