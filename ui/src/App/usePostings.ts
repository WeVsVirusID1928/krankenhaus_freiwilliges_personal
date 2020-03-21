import { useEffect, useState } from 'react';

export function usePostings() {
  const [postings, setPostings] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch('http://localhost:1357/postings')
      .then(response => response.json())
      .then(apiResponse => setPostings(apiResponse))
      .then(() => setLoading(false))
      .catch(err => {
        setLoading(false);
        setError(err);
      });
  }, []);

  return [postings, loading, error];
}
