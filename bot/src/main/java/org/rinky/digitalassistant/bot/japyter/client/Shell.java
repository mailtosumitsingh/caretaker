/*******************************************************************************
 * Copyright (c) 2015-2016 Open Analytics NV and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.rinky.digitalassistant.bot.japyter.client;

import static org.apache.commons.lang3.Validate.notBlank;
import static org.apache.commons.lang3.Validate.notNull;
import static org.rinky.digitalassistant.bot.japyter.client.Protocol.RequestMessageType.CONNECT_REQUEST;
import static org.rinky.digitalassistant.bot.japyter.client.Protocol.RequestMessageType.KERNEL_INFO_REQUEST;

import java.io.IOException;

import org.rinky.digitalassistant.bot.japyter.gen.CompleteReply;
import org.rinky.digitalassistant.bot.japyter.gen.CompleteRequest;
import org.rinky.digitalassistant.bot.japyter.gen.ConnectReply;
import org.rinky.digitalassistant.bot.japyter.gen.ExecuteReply;
import org.rinky.digitalassistant.bot.japyter.gen.ExecuteRequest;
import org.rinky.digitalassistant.bot.japyter.gen.HistoryReply;
import org.rinky.digitalassistant.bot.japyter.gen.HistoryRequest;
import org.rinky.digitalassistant.bot.japyter.gen.InspectReply;
import org.rinky.digitalassistant.bot.japyter.gen.InspectRequest;
import org.rinky.digitalassistant.bot.japyter.gen.IsCompleteReply;
import org.rinky.digitalassistant.bot.japyter.gen.IsCompleteRequest;
import org.rinky.digitalassistant.bot.japyter.gen.KernelInfoReply;
import org.rinky.digitalassistant.bot.japyter.gen.ShutdownReply;
import org.rinky.digitalassistant.bot.japyter.gen.ShutdownRequest;
import org.zeromq.ZMQ;

public class Shell extends AbstractSynchronousChannel
{
    public enum InspectDetailLevel
    {
        COARSE(0), FINE(1);

        private final int value;

        private InspectDetailLevel(final int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
    };

    public Shell(final String address, final Session session)
    {
        super(address, session);
    }

    @Override
    protected int getZmqSocketType()
    {
        return ZMQ.DEALER;
    }

    public ExecuteReply execute(final ExecuteRequest request) throws IOException
    {
        return send(request);
    }

    public InspectReply inspect(final String code, final int cursorPosition, final InspectDetailLevel level)
        throws IOException
    {
        return send(new InspectRequest().withCode(notBlank(code, "code can't be blank"))
            .withCursorPos(cursorPosition)
            .withDetailLevel(notNull(level, "level can't be null").getValue()));
    }

    public CompleteReply complete(final String code, final int cursorPosition) throws IOException
    {
        return send(new CompleteRequest().withCode(notBlank(code, "code can't be blank")).withCursorPos(
            cursorPosition));
    }

    public IsCompleteReply isComplete(final String code) throws IOException
    {
        return send(new IsCompleteRequest().withCode(notBlank(code, "code can't be blank")));
    }

    public HistoryReply history(final HistoryRequest request) throws IOException
    {
        return send(request);
    }

    public ConnectReply connect() throws IOException
    {
        return send(CONNECT_REQUEST);
    }

    public KernelInfoReply kernelInfo() throws IOException
    {
        return send(KERNEL_INFO_REQUEST);
    }

    public ShutdownReply shutdown(final boolean restart) throws IOException
    {
        return send(new ShutdownRequest().withRestart(restart));
    }
}
