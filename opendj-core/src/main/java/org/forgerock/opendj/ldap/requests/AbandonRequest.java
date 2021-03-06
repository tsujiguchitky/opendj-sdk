/*
 * CDDL HEADER START
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License, Version 1.0 only
 * (the "License").  You may not use this file except in compliance
 * with the License.
 *
 * You can obtain a copy of the license at legal-notices/CDDLv1_0.txt
 * or http://forgerock.org/license/CDDLv1.0.html.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the License file at legal-notices/CDDLv1_0.txt.
 * If applicable, add the following below this CDDL HEADER, with the
 * fields enclosed by brackets "[]" replaced with your own identifying
 * information:
 *      Portions Copyright [yyyy] [name of copyright owner]
 *
 * CDDL HEADER END
 *
 *
 *      Copyright 2009-2010 Sun Microsystems, Inc.
 *      Portions copyright 2012 ForgeRock AS.
 */

package org.forgerock.opendj.ldap.requests;

import java.util.List;

import org.forgerock.opendj.ldap.DecodeException;
import org.forgerock.opendj.ldap.DecodeOptions;
import org.forgerock.opendj.ldap.controls.Control;
import org.forgerock.opendj.ldap.controls.ControlDecoder;

/**
 * The Abandon operation allows a client to request that the server abandon an
 * uncompleted operation.
 * <p>
 * Abandon, Bind, Unbind, and StartTLS operations cannot be abandoned.
 */
public interface AbandonRequest extends Request {

    @Override
    AbandonRequest addControl(Control control);

    @Override
    <C extends Control> C getControl(ControlDecoder<C> decoder, DecodeOptions options)
            throws DecodeException;

    @Override
    List<Control> getControls();

    /**
     * Returns the request ID of the request to be abandoned.
     *
     * @return The request ID of the request to be abandoned.
     */
    int getRequestID();

    /**
     * Sets the request ID of the request to be abandoned.
     *
     * @param id
     *            The request ID of the request to be abandoned.
     * @return This abandon request.
     * @throws UnsupportedOperationException
     *             If this abandon request does not permit the request ID to be
     *             set.
     */
    AbandonRequest setRequestID(int id);

}
