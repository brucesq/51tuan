/**
 * 
 */
package com.tuan.util;

import java.util.List;

import com.aspire.wap.core.common.StringUtil;

/**
 * Html message parser
 * @author BruceSun
 *
 */
public class HTMLMessageParser {

	/**
	 * Parse inline html content.
	 * @param item
	 * @param str
	 * @return
	 */
//	public static String parseInlineHTMLContent(MailItem item, String str) {
//		if ((str == null) || (str.equals("")))
//			return "";
//		int i = -1;
//		// cid with double quotes
//		String tmp = null;
//		String contentId = null;
//		int j = -1;
//		int partId = -1;
//		while ((i=str.indexOf("\"cid:")) != -1) {
//			tmp = str.substring(i + 5);
//			j = tmp.indexOf("\"");
//			contentId = tmp.substring(0, j);
//			partId = getPartIdByContentId(item, contentId);
//
//			str = str.substring(0, i) + "\"dumpPart?part_id=" + partId + "\"" + tmp.substring(j + 1);
//		}
//		
//		return str;
//	}
	
//	
//	@SuppressWarnings("unchecked")
//	private static int getPartIdByContentId(MailItem item, String cid) {
//		List<MailPart> parts = item.getParts();
//		for (MailPart part : parts) {
//			String contentId = part.getContentId();
//			String fileName = part.getFilename();
//			if ((contentId != null && contentId.equals(cid))
//					|| (fileName!=null && fileName.equalsIgnoreCase(cid))) {
//				return part.getId();
//			}
//		}
//		// still havent found it. maybe cid is surrounded with < > 
//		for (MailPart part : parts) {
//			String contentId = part.getContentId();
//			contentId = StringUtil.extendedTrim(contentId, "<");
//			contentId = StringUtil.extendedTrim(contentId, ">");
//			if (contentId != null && contentId.equals(cid)) {
//				return part.getId();
//			}
//		}
//		return -1;
//	}
}
