package com.td.mbna.msec.midtier.util;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

import com.td.mbna.msec.midtier.framework.FrameworkUtil;

/**
 * 
 * This class contains helper methods for calling the stub implementation of the operation.
 *
 */
public final class StubUtil {
	
	private final static boolean InDevMode = com.td.mbna.msec.midtier.util.ConfigUtil.inDevMode();
	
	private static MbnaLogger logger = new MbnaLogger(StubUtil.class);
	
	private final static String FS = System.getProperty("file.separator");

	private final static String ConfigDirName = ConfigUtil.getConfigDirectory();
	private final static String TdConfigDirName = ConfigDirName + "tdStubs" + FS;
	
	private final static String ConfigDirCanonName;
	private final static String TdConfigDirCanonName;
	
	
	static {
		String s1 = null, s2 = null;
		try {
			s1 = new File(ConfigDirName).getCanonicalPath();
			s2 = new File(TdConfigDirName).getCanonicalPath();
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		ConfigDirCanonName = s1;
		TdConfigDirCanonName = s2;
	}
	
	/**
	 * generate stub filename
	 * @param implClass
	 * @param userId
	 * @return
	 */
	public static String genStubFileName(Class<?> implClass, String userId) {
		if (!InDevMode) {
			throw new UnsupportedOperationException("Stub operation disabled in production mode");
		}
		return genStubFileName(implClass, userId, null);
	}

	/**
	 * generate TD request stub XML filename
	 * @param tdOp
	 * @param userId
	 * @param acctNum
	 * @return
	 */
	public static String genTdRqStubXmlFileName(String tdOp, String userId, String acctNum) {
		if (!InDevMode) {
			throw new UnsupportedOperationException("Stub operation disabled in production mode");
		}
		return genTdXmlFileName(tdOp, "Rq", userId, acctNum);
	}
	
	/**
	 * generate TD Response Stub XML filename
	 * @param tdOp
	 * @param userId
	 * @param acctNum
	 * @return
	 */
	public static String genTdRsStubXmlFileName(String tdOp, String userId, String acctNum) {
		if (!InDevMode) {
			throw new UnsupportedOperationException("Stub operation disabled in production mode");
		}
		return genTdXmlFileName(tdOp, "Rs", userId, acctNum);
	}

	/**
	 * Retrieve stub directory name
	 * @param userId
	 * @param acctNum
	 * @return
	 */
	public static String getStubDirName(String userId, String acctNum) {
		if (!InDevMode) {
			throw new UnsupportedOperationException("Stub operation disabled in production mode");
		}
		return getStubDirName(ConfigDirName, userId, acctNum);
	}
	
	/**
	 * Retrieve stub directory name
	 * @param configDirName
	 * @param userId
	 * @param acctNum
	 * @return
	 */
	public static String getStubDirName(String configDirName, String userId, String acctNum) {
		if (!InDevMode) {
			throw new UnsupportedOperationException("Stub operation disabled in production mode");
		}
		String stubDirName = configDirName;
		if (userId != null) {
			String userDirName = configDirName + userId + FS;
			File userDir = new File(userDirName);
			if (userDir.exists() && userDir.isDirectory()) {
				stubDirName = userDirName;
				if (acctNum != null) {
					String acctDirName = stubDirName + "accounts" + FS + acctNum + FS;
					File acctDir = new File(acctDirName);
					if (acctDir.exists() && acctDir.isDirectory()) {
						stubDirName = acctDirName;
					}
				}
			}
		}
		return stubDirName;
	}
	
	/**
	 * get TD XML directory name
	 * @param userId
	 * @param acctNum
	 * @return
	 */
	public static String getTdXmlDirName(String userId, String acctNum) {
		if (!InDevMode) {
			throw new UnsupportedOperationException("Stub operation disabled in production mode");
		}
		return getStubDirName(TdConfigDirName, userId, acctNum);
	}
	
	/**
	 * generate TD XML filename
	 * @param tdOp
	 * @param RqRes
	 * @param userId
	 * @param acctNum
	 * @return
	 */
	public static String genTdXmlFileName(String tdOp, String RqRes, String userId, String acctNum) {
		if (!InDevMode) {
			throw new UnsupportedOperationException("Stub operation disabled in production mode");
		}
		String fileName = genOpFileName(tdOp, RqRes);
		String dirName = getTdXmlDirName(userId, acctNum);
		String rc = dirName + fileName;
		boolean fileExists = false;
		boolean searchedRootLevelAccount = false;
		try {
			while (!(fileExists = (new File(rc).exists()))) {
				dirName = StubUtil.getParentDir(dirName);
				if (dirName == null) {
					break;
				}
				if (acctNum != null && dirName.equals(TdConfigDirCanonName+FS) && !searchedRootLevelAccount) {
					// if account number is specified, search the accounts subfolder underneath the root folder also
					searchedRootLevelAccount = true;
					dirName = TdConfigDirName +  "accounts" + FS + acctNum + FS;
				}
				rc = dirName.concat(fileName);
			}
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if (!fileExists) {
			rc = null;
		}
		return rc;
	}
	
	/**
	 * Generate stub filename
	 * @param implClass
	 * @param userId
	 * @param acctNum
	 * @return
	 */
	public static String genStubFileName(Class<?> implClass, String userId, String acctNum) {
		if (!InDevMode) {
			throw new UnsupportedOperationException("Stub operation disabled in production mode");
		}
		String fileName = FrameworkUtil.getOpName(implClass) + ".xml";
		fileName = fileName.substring(0,1).toLowerCase(Locale.CANADA) + fileName.substring(1);
		return getStubDirName(userId, acctNum) + fileName;
	}
	
	/**
	 * Generate stub filename
	 * @param implClass
	 * @param parentDir
	 * @return
	 */
	public static String genStubFileName(Class<?> implClass, File parentDir) {
		if (!InDevMode) {
			throw new UnsupportedOperationException("Stub operation disabled in production mode");
		}
		String fileName = FrameworkUtil.getOpName(implClass) + ".xml";
		fileName = fileName.substring(0,1).toLowerCase(Locale.CANADA) + fileName.substring(1);
		String parentDirName = parentDir.getAbsolutePath();
		if (!parentDirName.endsWith(FS)) {
			parentDirName = parentDirName.concat(FS);
		}
		return parentDirName + fileName;
	}

	/**
	 * Generate stub filename
	 * @param operation
	 * @param userId
	 * @return
	 */
	public static String genStubFileName(String operation, String userId) {
		if (!InDevMode) {
			throw new UnsupportedOperationException("Stub operation disabled in production mode");
		}
		String fileName = operation.concat(".xml");
		fileName = fileName.substring(0,1).toLowerCase(Locale.CANADA) + fileName.substring(1);
		return getStubDirName(userId, null) + fileName;
	}

	/**
	 * Get contact stub directory name
	 * @param parentDir
	 * @param custId
	 * @return
	 */
	public static String getContactStubDirName(String parentDir, String custId) { // this method can be used by both real & stub impl by passing in different parent dir
		if (!InDevMode) {
			throw new UnsupportedOperationException("Stub operation disabled in production mode");
		}
		String rc = parentDir;
		if (custId != null) {
			String contactDirName = rc + "contacts" + FS + custId + FS;
			File contactDir = new File(contactDirName);
			if (contactDir.exists() && contactDir.isDirectory()) {
				rc = contactDirName;
			}
		}
		return rc;
	}
	
	/**
	 * get parent directory
	 * @param dirName
	 * @return
	 */
	public static String getParentDir(String dirName) {
		if (!InDevMode) {throw new UnsupportedOperationException("Stub operation disabled in production mode");}
		File dir = new File(dirName);
		try {
			String dirCanonPath = dir.getCanonicalPath();
			if (dirCanonPath.equals(TdConfigDirCanonName)) return null;
			if (dirCanonPath.equals(ConfigDirCanonName)) return null;
			File parentDir = dir.getParentFile();
			if (parentDir == null) return null;
			String parentDirName = parentDir.getCanonicalPath();
			if (parentDirName != null && !parentDirName.endsWith(FS)) {
				parentDirName = parentDirName.concat(FS);
			}
			if (parentDirName.endsWith("accounts"+FS)) {
				parentDirName = parentDir.getParent();
				if (parentDirName != null && !parentDirName.endsWith(FS)) {
					parentDirName = parentDirName.concat(FS);
				}
			}
			return parentDirName;
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * Get TD request stub XML file content
	 * @param tdOp
	 * @param userId
	 * @param acctNum
	 * @return
	 */
	public static String getTdRqStubXmlFileContent(String tdOp, String userId, String acctNum) {
		if (!InDevMode) {throw new UnsupportedOperationException("Stub operation disabled in production mode");}
		String filename = genTdXmlFileName(tdOp, "Rq", userId, acctNum);
		try {
			return new Scanner(new File(filename)).useDelimiter("\\Z").next();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * Get Td response stub XML file content
	 * @param tdOp
	 * @param userId
	 * @param acctNum
	 * @return
	 */
	public static String getTdRsStubXmlFileContent(String tdOp, String userId, String acctNum) {
		if (!InDevMode) {throw new UnsupportedOperationException("Stub operation disabled in production mode");}
		String filename = genTdXmlFileName(tdOp, "Rs", userId, acctNum);
		try {
			return new Scanner(new File(filename)).useDelimiter("\u001a").next();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	

	private static String genOpFileName(String tdOp, String RqRes) {
		if (!InDevMode) {throw new UnsupportedOperationException("Stub operation disabled in production mode");}
		String fileName = tdOp + RqRes + ".xml";
		fileName = fileName.substring(0,1).toLowerCase(Locale.CANADA) + fileName.substring(1);
		return fileName;
	}
	
}
