import React, {Component} from 'react';
import { Modal, Alert } from 'react-bootstrap';

export default class ErrorPopup extends Component {
  render() {
    return (
      <Modal show={this.props.show} onHide={this.props.close} className="modal modal-danger">
  	    <Modal.Header className="modal-header" closeButton>
  	      <Modal.Title>
  	        <span className="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>&nbsp;
  	        Error
  	      </Modal.Title>
  	    </Modal.Header>
  	    <Modal.Body className="modal-body">
  	      {this.props.message}
  	    </Modal.Body>
        <Modal.Footer className="modal-footer">
          <button className="btn btn-outline pull-right" onClick={this.props.close}>Close</button>
        </Modal.Footer>
  	  </Modal>
    );
  }
}
