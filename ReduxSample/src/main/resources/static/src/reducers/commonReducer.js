import { browserHistory } from 'react-router';

export const POPUP_OPEN = 'popup/OPEN';
export const POPUP_CLOSE = 'popup/CLOSE';

export const redirect = (redirectURI) => {
  console.log(" @@ called redirect : " + redirectURI);
  browserHistory.push(redirectURI);
}

export const closePopup = (redirectURI) => {
  return {
    type: POPUP_CLOSE,
    redirectURI
  }
}