//package com.finablr.admin.utilities;
//
//public class EmailReading {
//
//	
//	public static String EmailReading(String mailFolderName,String emailSubjectContent, String emailContent, int lengthOfOTP) {
//
//        
//		//mailFolderName(Eg- "INBOX"), emailSubjectContent(Eg- Mail for OTP),
//		emailContent(Eg- OTP is 111111), OTP length(Eg- 6)
//		            String hostName = "smtp-mail.outlook.com";//change it according to your mail
//
//		            String username = "****@***.com";//username 
//
//		            String password = "*******";
//
//		            int messageCount;
//
//		            int unreadMsgCount;
//
//		            String emailSubject;
//
//		            Message emailMessage;
//
//		            String searchText=null ;
//
//		            Properties sysProps = System.getProperties();
//
//		            sysProps.setProperty("mail.store.protocol", "imaps");
//
//		            try {
//
//		                Session session = Session.getInstance(sysProps, null);
//
//		                Store store = session.getStore();
//
//		                store.connect(hostName, username, password);
//
//		                Folder emailBox = store.getFolder(mailFolderName);
//
//		                emailBox.open(Folder.READ_WRITE);
//
//		                messageCount = emailBox.getMessageCount();
//
//		                System.out.println("Total Message Count: " + messageCount);
//
//		                unreadMsgCount = emailBox.getNewMessageCount();
//
//		                System.out.println("Unread Emails count:" + unreadMsgCount);
//
//		                for(int i=messageCount; i>(messageCount-unreadMsgCount); i--)
//
//		                {
//
//		                    emailMessage = emailBox.getMessage(i);
//
//		                    emailSubject = emailMessage.getSubject();
//
//		                    if(emailSubject.contains(emailSubjectContent))
//
//		                    {
//
//		                        System.out.println("OTP mail found");
//
//		                        String line;
//
//		                        StringBuffer buffer = new StringBuffer();
//
//		                        BufferedReader reader = new BufferedReader(new InputStreamReader(emailMessage.getInputStream()));
//
//		                        while ((line = reader.readLine()) != null) {
//
//		                            buffer.append(line);
//
//		                        }
//
//		                        String messageContent=emailContent;
//
//		                        String result = buffer.toString().substring(buffer.toString().indexOf(messageContent));
//
//		                        searchText = result.substring(messageContent.length(), messageContent.length()+lengthOfOTP);
//
//		                        System.out.println("Text found : "+ searchText);
//
//		                        emailMessage.setFlag(Flags.Flag.SEEN, true);
//
//		                        break;
//
//		                    }
//
//		                    emailMessage.setFlag(Flags.Flag.SEEN, true);
//
//		                }
//
//		                emailBox.close(true);
//
//		                store.close();
//
//
//		            } catch (Exception mex) {
//
//		                mex.printStackTrace();
//
//		                System.out.println("OTP Not found ");
//
//		            }
//
//		            return searchText;
//
//		        }
//}
