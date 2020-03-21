import { useEffect, useState } from 'react';

interface Posting {
  title: string;
  time: string;
  comment: string;
  contact: string;
}

export function usePostings(): [Posting[] | null, boolean, Error | null] {
  const [postings, setPostings] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch('http://localhost:1357/postings')
      .then(response => response.json())
      .then(apiResponse => setPostings(apiResponse.postings))
      .then(() => setLoading(false))
      .catch(err => {
        setLoading(false);
        setError(err);
      });
  }, []);

  return [postings, loading, error];
}
