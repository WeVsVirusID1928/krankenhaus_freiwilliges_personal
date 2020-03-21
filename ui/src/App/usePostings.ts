import React, { useState, useEffect } from 'react';
const postingsUrl = 'http://localhost:1357/postings';

interface Posting {
  title: string;
  time: string;
  comment: string;
  contact: string;
}

export function usePostings(): [
  (newPosting: Posting) => void,
  Posting[] | null,
  boolean,
  Error | null
] {
  const [postings, setPostings] = useState<Posting[] | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const getPostings = async () => {
    try {
      const rawResponse = await fetch(postingsUrl);
      const response = await rawResponse.json();
      setPostings(response.postings);
      setLoading(false);
    } catch (err) {
      setLoading(false);
      setError(err);
    }
  };

  const postThenGetPostings = async (newPosting: Posting) => {
    await fetch(postingsUrl, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(newPosting)
    });
    await getPostings();
  };

  useEffect(() => {
    getPostings();
  }, []);

  return [postThenGetPostings, postings, loading, error];
}
